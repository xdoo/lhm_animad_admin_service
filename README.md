# lhm_animad_admin_service
The animad backend - generated from the 'animad.barrakuda' model by the Barrakuda Web Generator available under http://krause:10001/.

# Prerequisites for the build
* Search in all pom files for '1.0-SNAPSHOT' and replace with '1.0' (should be 10 matches).
* comment out the oracle driver dependency in the animad_administration_service pom file
* Do a 'mvn install -DskipTests'.

# Changes to the auto-generated code
* service security disabled (until it's implemented) by commenting out '@PreAuthorize' (19 matches).
* comment out (until infrastructure is ready) the @EnableEurekaClient annotation in the MicroServiceApplication class.
* change security settings in application.yml:
    ```application.yml
    # Security
    # security.oauth2.resource.userInfoUri: http://AUTHSERVICE/uaa/user
    # security.oauth2.resource.preferTokenInfo: false
    security.ignored: /**
    ```
*
