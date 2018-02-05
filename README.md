# Jiminy HTML server
This is one component in a suite that includes the [Jiminy modeler](https://github.com/radanalyticsio/jiminy-modeler) and the [Jiminy predictor](https://github.com/radanalyticsio/jiminy-predictor). This Java application is designed to provide a web UI for adding movie ratings as well as retrieving movie recommendations from the predictor service.
Technologies included are:
* Spring Boot
* Spring Data JPA
* REST
* Swagger UI
## Usage
The application can be run in two ways:

`mvn package` then `java -jar target\/jiminy-html-server-1.0.0-SNAPSHOT.jar`

The Maven POM has the Spring Boot plugin configured so the app can also be run using:

`mvn spring-boot:run`

Once the application is started, point your browser to http://localhost:8181/

The UI is served as static content from the resources dir. [Webpack](https://webpack.js.org/) is used to bundle the web assets into one file. If assets need to be rebundled then:
```bash
npm install
npm run build
```

## Configuration

## Swagger
You can retrieve a Swagger UI definition from the running service. For example: http://localhost:8181/swagger-ui.html

## s2i

```bash
oc new-app -p APPLICATION_NAME=jiminy-html-service \
    -p GIT_URI=https://github.com/radanalyticsio/jiminy-html-service \ 
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgresql:5432/postgres \
    -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=postgres \
    -e OPENSHIFT_CONFIG_PREDICTOR_URL=http://predictor-elmiko.apps.jiminy.radanalyticslabs.io/predictions/ranks
```
    
Note to make sure the OPENSHIFT_CONFIG_PREDICTOR_URL is set for the correct route to the predictor endpoint.

`oc expose svc/jiminy-html-service`
