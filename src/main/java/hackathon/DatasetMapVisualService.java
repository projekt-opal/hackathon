package hackathon;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.springframework.stereotype.Service;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.rdf.model.NodeIterator;

@Service
public class DatasetMapVisualService {

	public static void extract_coordinates(Resource datasetURI, RDFNode obj, List<Dataset> datasetList,
			int dataset_id_counter, ArrayList<String[]> dataset_coordinates, Boolean blanknode) {

		String coordinate_points[] = null;
		if (blanknode) {
			coordinate_points = obj.toString().replace("POLYGON", "").replace("((", "")
					.replace("))^^http://www.openlinksw.com/schemas/virtrdf#Geometry", "").trim().split(",");
		} else {
			coordinate_points = obj.toString().replace("POLYGON", "").replace("((", "").replace("))", "").trim()
					.split(",");
		}

		System.out.println("coordinate points = " + Arrays.toString(coordinate_points));
		System.out.println(coordinate_points.length);

		// Make a linear ring using geoTools to find the centroid coordinate
		ArrayList<Coordinate> linear_ring = new ArrayList<Coordinate>();
		for (int count = 0; count < coordinate_points.length; count++) {

			System.out.println(coordinate_points[count].trim().split(" ")[0]);
			System.out.println(coordinate_points[count].trim().split(" ")[1]);

			dataset_coordinates.add(new String[] { coordinate_points[count].trim().split(" ")[1],
					coordinate_points[count].trim().split(" ")[0] });

			linear_ring.add(new Coordinate(Double.parseDouble(coordinate_points[count].trim().split(" ")[1]),
					Double.parseDouble(coordinate_points[count].trim().split(" ")[0])));

		}

		// geometryfactory object will be used to perform geometrical operations
		GeometryFactory geometryFactory = new GeometryFactory();

		LineString polygon = geometryFactory.createLineString((Coordinate[]) linear_ring.toArray(new Coordinate[] {}));

		String centroid[] = polygon.getCentroid().toString().replace("POINT", "").replace("(", "").replace(")", "")
				.trim().split(" ");
		System.out.println(Arrays.toString(linear_ring.toArray()));

		Dataset dataset = new Dataset(dataset_id_counter, dataset_coordinates, centroid, "polygon",
				datasetURI.toString());
		datasetList.add(dataset);

	}

	public List<Dataset> getAllDatasets(String DatasetUri, String turtle_file) {
		// public static void main(String[] args) {

		List<Dataset> datasetList = new ArrayList<Dataset>();

		// This id will be used in the frontend to produce div for datasets
		int dataset_id_counter = 1;

		// Stores latitude and longitude of all points
		ArrayList<String[]> dataset_coordinates = new ArrayList<String[]>();

		String file_name = new DatasetMapVisualService().getClass().getClassLoader().getResource(turtle_file)
				.toString();

		Model my_model = ModelFactory.createDefaultModel();
		Resource datasetURI = my_model.createResource(DatasetUri);
		my_model.read(file_name);

		// To prevent readdition of URI into datasetList
		String toggle = "on";

		if (datasetURI.hasProperty(DCTerms.spatial)) {

			NodeIterator spatialobjects = my_model.listObjectsOfProperty(datasetURI, DCTerms.spatial);

			while (spatialobjects.hasNext()) {
				RDFNode spatialobject = spatialobjects.next();

				/**
				 * dct:spatial's object is a blank_node resource with it's own dct:spatial
				 * property
				 */
				if (spatialobject.isAnon()) {

					Property geometry = my_model.createProperty("http://www.w3.org/ns/locn#geometry");
					Resource blank_node = (Resource) datasetURI.getProperty(DCTerms.spatial).getObject();
					if (blank_node.hasProperty(geometry)) {

						NodeIterator geoNodes = my_model.listObjectsOfProperty(blank_node, geometry);
						while (geoNodes.hasNext()) {

							RDFNode literal = geoNodes.nextNode();
							if (literal.toString().contains("POLYGON")) {
								if (toggle == "on")
									extract_coordinates(datasetURI, literal, datasetList, dataset_id_counter,
											dataset_coordinates, true);
								toggle = "off";
							}

							System.out.println(literal.toString());
						}
					}

				}

				// dct:spatial's object contains polygon coodrinates directly
				if (spatialobject.toString().contains("POLYGON")) {
					if (toggle == "on") {
						extract_coordinates(datasetURI, datasetURI.getProperty(DCTerms.spatial).getObject(),
								datasetList, dataset_id_counter, dataset_coordinates, false);
						toggle = "off";
					}
				}

				dataset_id_counter++;
			}
		}

//		for(Dataset a:datasetList)
//			System.out.println(a.getDatasetURI());
		return datasetList;
	}

}
