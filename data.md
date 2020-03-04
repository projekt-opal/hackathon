# Data

We focus on two types of data: Open metadata records and mobility datasets.

## Open metadata records

### RDF (Resource Description Framework)

In the DICE group, we focus on graphs consisting of RDF data. The main concepts are described at [RDF 1.1 Primer](https://www.w3.org/TR/rdf11-primer/).

### DCAT (Data Catalog Vocabulary)

DCAT is an RDF vocabulary which enables to describe datasets and related concepts. It is described at [Data Catalog Vocabulary (DCAT) - Version 2](https://www.w3.org/TR/vocab-dcat-2/).

### SPARQL (SPARQL Protocol and RDF Query Language)

Like SQL for relational databases, SPARQL can be used to query RDF databases (triplestores). The specification can be found at [SPARQL 1.1 Query Language](https://www.w3.org/TR/sparql11-query/).

## Mobility datasets

If you want to work with mobility datasets, you can explore and download them at different open data portals.
Have a look here:
[mCLOUD](https://www.mcloud.de/), 
[GovData](https://www.govdata.de/), 
[European Data Portal](https://www.europeandataportal.eu/) or
[EU Open Data portal](https://data.europa.eu/euodp/en/data/).

## Examples

### RDF example

![RDF example](https://www.w3.org/TR/rdf11-primer/example-graph-iris.jpg)

### DCAT overview

![DCAT overview](https://www.w3.org/TR/vocab-dcat-2/images/DCAT-summary-all-attributes.png)

### SPARQL example

Try a SPARQL query at the [European Data Portal SPARQL endpoint](https://www.europeandataportal.eu/sparql): Using the DCAT specification, we request 100 download URLs of datasets:

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



