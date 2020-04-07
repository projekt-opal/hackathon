# DatasetLocator
- This is a maven project implemented in Spring Boot and GoogleMap JS library.
- At this moment, the app can show location of only one dataset in the Google map.

## How it works?
- The app has been designed in an MVC approach.
- There is only one controller called "**DatasetMapVisualController**" which is using a service called "**DatasetMapVisualService**" and calling method **getAllDatasets(DatasetURI,model)** which takes two parameters a dataset URI and name of the turtule file containing the dataset. The app has been developed with a futuristic plan to show multiple datasets on the map.
- The service at this moment, returns only one object with some properties such as id, lattitude and longitude etc.
- The controller passes this object to Thymeleaf template **maps.html**.
- In maps.html, we have only one div with one id called "map" which is be mounted inside js script to render the location of the dataset.

## Run the application
- It can be run directly from command line as **mvn sprint-boot:run**.
- The app is reading a model from Resources/testdata.ttl and dataset URI is being passed in the controller file which is located at "**hackathon\src\main\java\hackathon\DatasetMapVisualController**"
