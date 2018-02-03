# Jiminy HTML server
## Usage
`mvn spring-boot:run`
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
