# Data

We focus on two types of data: **Open metadata records** and **mobility datasets**.  
Data formats are described on page [formats](formats.md).

## Open metadata records

Here you can access DCAT/RDF data:

* [European Data Portal SPARQL endpoint](https://www.europeandataportal.eu/sparql)
* [OPAL data dumps](https://hobbitdata.informatik.uni-leipzig.de/OPAL/)

### SPARQL examples

Try a SPARQL query at a SPARQL endpoint (see above).

#### Request 100 download URLs of DCAT datasets

```SPARQL
PREFIX dcat: <http://www.w3.org/ns/dcat#>
PREFIX dct: <http://purl.org/dc/terms/>

SELECT ?title ?url WHERE {
  ?dataset a dcat:Dataset .
  ?dataset dct:title ?title .
  ?dataset dcat:distribution ?distribution .
  ?distribution dcat:downloadURL ?url .
}
LIMIT 100
OFFSET 0
```

## Mobility datasets

If you want to work with mobility datasets, you can explore and download them at different open data portals.
Have a look here:
[OPAL](https://opal.demos.dice-research.org/),
[mCLOUD](https://www.mcloud.de/), 
[GovData](https://www.govdata.de/), 
[European Data Portal](https://www.europeandataportal.eu/),
[EU Open Data portal](https://data.europa.eu/euodp/en/data/) and
[other portals](https://github.com/projekt-opal/doc/wiki/Open-Data-Portals).
If you can not find Paderborn data, try to search for "NRW" / "North Rhine-Westphalia" / "Nordrhein-Westfalen".

For data related to Paderborn have a look at [Open Data Paderborn](open-data-paderborn.md).

A RDF version of OpenStreetMap is available at [LinkedGeoData.org](http://linkedgeodata.org).

[Start page](index.md)
