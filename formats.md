# Data formats

Three data concepts are important: **RDF** (format), **DCAT** (vocabulary) and **SPARQL** (query language).
Data access is described at page [data](data.md)

## RDF (Resource Description Framework)

We focus on graphs consisting of RDF data. The main concepts are described at [RDF 1.1 Primer](https://www.w3.org/TR/rdf11-primer/).

![RDF example](https://www.w3.org/TR/rdf11-primer/example-graph-iris.jpg)

## DCAT (Data Catalog Vocabulary)

DCAT is an RDF vocabulary which enables to describe datasets and related concepts. The classes of interest are dcat:Dataset and dcat:Distribution (a specific representation of a dataset). DCAT is described at [Data Catalog Vocabulary (DCAT) - Version 2](https://www.w3.org/TR/vocab-dcat-2/).

![DCAT overview](https://www.w3.org/TR/vocab-dcat-2/images/DCAT-summary-all-attributes.png)

## SPARQL (SPARQL Protocol and RDF Query Language)

Like SQL for relational databases, SPARQL can be used to query RDF databases (triplestores). The specification can be found at [SPARQL 1.1 Query Language](https://www.w3.org/TR/sparql11-query/).
SPARQL examples are available at [data](data.md).
