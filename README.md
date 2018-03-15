# Jiminy HTML server
This is one component of the [Jiminy project](https://radanalytics.io/applications/project-jiminy) (that includes the [Jiminy modeler](https://github.com/radanalyticsio/jiminy-modeler) and the [Jiminy predictor](https://github.com/radanalyticsio/jiminy-predictor)). This Java application is designed to provide a web UI for adding movie ratings as well as retrieving movie recommendations from the predictor service.
Technologies included are:

* Spring Boot
* Spring Data JPA
* REST
* Swagger UI

## Usage
The application can be run in two ways:

`mvn package` then `java -jar target\jiminy-html-server-1.0.0-SNAPSHOT.jar`

The Maven POM has the Spring Boot plugin configured so the app can also be run using:

```bash
mvn spring-boot:run
```

Once the application is started, point your browser to `http://localhost:8181/`

The UI is served as static content from the resources dir. [Webpack](https://webpack.js.org/) is used to bundle the web assets into one file. If assets need to be rebundled then:

```bash
npm install
npm run build
```

## Configuration
Application configuration has been externalized to a YAML file that is read and values injected into the app via Spring annotations. Note that Spring has the capability to interpret those configuration properties as environment variables using relaxed binding. See below in [s2i](#s2i).

## Swagger
You can retrieve a Swagger UI definition from the running service. For example: http://localhost:8181/swagger-ui.html

## [s2i](#s2i)
This application can be deployed in OpenShift environments and built "on-the-fly" using source-to-image (s2i). An appropriate image builder is the `fabric8/s2i-java` image.

```bash
oc new-app fabric8/s2i-java~https://github.com/radanalyticsio/jiminy-html-server.git \
    -p APPLICATION_NAME=jiminy-html-server \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgresql:5432/postgres \
    -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=postgres \
    -e OPENSHIFT_CONFIG_PREDICTOR_URL=http://predictor-elmiko.apps.jiminy.radanalyticslabs.io/predictions/ranks
```
    
Note to make sure the OPENSHIFT_CONFIG_PREDICTOR_URL is set for the correct route to the predictor endpoint.

```bash
oc expose svc/jiminy-html-server
```
