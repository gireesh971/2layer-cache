# refer-arch-aws

Dummy skeleton to demostrate a possible design for a 2 layer cache for data service.

1. mvn test
2. mvn spring-boot:run
3. Get a value:
    curl http://localhost:8080/cache/api/service?key=key
4. Save a value:
    curl --data "key=my-key" --data "value=my-value" http://localhost:8080/cache/api/service



