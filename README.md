# lhm_animad_admin_service
The animad backend - generated from the 'animad.barrakuda' model by the Barrakuda Web Generator available under http://krause:10001/.

# Changes to the auto-generated code
* Search in all pom files for '1.0-SNAPSHOT' and replace with '1.0' (should be 10 matches)
* commented out the oracle driver dependency in the animad_administration_service pom file
* commented out service security (until it's implemented) by commenting out `@PreAuthorize` (19 matches)
* commented out (until infrastructure is ready) the `@EnableEurekaClient` annotation in the `MicroServiceApplication` class
* security settings changed (until implemented) in application.yml:
    ```application.yml
    # Security
    # security.oauth2.resource.userInfoUri: http://AUTHSERVICE/uaa/user
    # security.oauth2.resource.preferTokenInfo: false
    security.ignored: /**
    ```
* fix server port added to the service in application.yml: `server.port: 39146`

# Build it
* Copy the libraries from the folder 'mvn_repo' in your local '.m2' repository - these are not available in the maven central repository
* Do a `mvn install -DskipTests`

# Run it
* Do a `mvn spring-boot:run`
* after that you can acces the service with your favorite REST client under e.g. http://localhost:39146/animals
