# Tasks

In the OPAL project, we're working with DCAT datasets in RDF format (see [formats](formats.md)).
This is the basis of the hackathon.
There are ideas for components that could be used in the project.

## Metadata + JavaScript Visualization

Datasets may contain spatial information (geo coordinates).
The spatial information could be visualized as a map like at [OpenDataMonitor](https://opendatamonitor.eu/).
For this you can use a JavaScript library, framework or API. Some examples are listed in this [article](https://geoawesomeness.com/top-19-online-geovisualization-tools-apis-libraries-beautiful-maps/).

An example to query spatial data is given in the following code.
Note that the returned results have different types and the query has to be refined.
You can execute the query a SPARQL endpoint listed at [data](data.md).

```SPARQL
PREFIX dcat: <http://www.w3.org/ns/dcat#>
PREFIX dct: <http://purl.org/dc/terms/>

SELECT * WHERE {
  ?dataset a dcat:Dataset .
  ?dataset dct:spatial ?spatial .
}
LIMIT 100
OFFSET 0
```

## Metadata + Data Science approach

Maybe you already played around with some scientific approaches.
That could for instance be a topic extraction or a statistical analysis.
You are free to apply those approaches to the available metadata records.

An idea is to first create a set of titles, descriptions and categories of existing datasets.
As not for all datasets a category is set, this could become a supervised (machine learning) categorization task.
Use the complete datasets to create a model containing used words on the one hand and categories on the other hand.
Based on comparisons of word vectors, categories can be set for datasets without categories.

Note that some approaches already have been implemented, e.g.
[automatic quality assessment](https://github.com/projekt-opal/civet),
[language detection and geodata extraction](https://github.com/projekt-opal/metadata-refinement),
[geographical topic extraction](https://github.com/projekt-opal/Topic-Extraction) and
[data slicing](https://github.com/projekt-opal/ElasticTriples).
You can also improve the implementations.

## Metadata + Metadata + Data + Data

If you already found multiple datasets, that are related to each other, you could think about combining them into one dataset.
This could be two datasets concerning the same topic, e.g. the field of traffic or the same time period or the same city.
Feel free to work on combining such datasets.
But before publishing created data, check the underlying licenses!
