package hackathon;

import java.util.ArrayList;

public class Dataset {

	private int id;
	private ArrayList<String[]> latlong;
	private String centre_coordinate[];
	private String geometry;
	private String DatasetURI;

	public Dataset(int id, ArrayList<String[]> latlong, String[] centre_coordinate, String geometry,
			String datasetURI) {
		super();
		this.id = id;
		this.latlong = latlong;
		this.centre_coordinate = centre_coordinate;
		this.geometry = geometry;
		DatasetURI = datasetURI;
	}

	public String getDatasetURI() {
		return DatasetURI;
	}

	public void setDatasetURI(String datasetURI) {
		DatasetURI = datasetURI;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String[]> getLatlong() {
		return latlong;
	}

	public Dataset() {

	}

	public void setLatlong(ArrayList<String[]> latlong) {
		this.latlong = latlong;
	}

	public String[] getCentre_coordinate() {
		return centre_coordinate;
	}

	public void setCentre_coordinate(String[] centre_coordinate) {
		this.centre_coordinate = centre_coordinate;
	}

	public String getGeometry() {
		return geometry;
	}

	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}

}
