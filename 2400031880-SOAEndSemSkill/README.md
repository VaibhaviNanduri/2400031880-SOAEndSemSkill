# 2400031880-SOAEndSemSkill

## Requirements
- Spring Tool Suite 4 or newer
- JDK 17
- Maven (STS includes Maven integration)

## Project structure
- `product-provider`: Provider REST API, runs on port 8081
- `order-consumer`: Consumer REST API, runs on port 8082 and calls the provider
- `contracts/product-by-id.yml`: YAML contract/request-response specification
- `requests/product-provider.http`: ready-to-run GET requests

## Import into STS
1. Extract the ZIP file.
2. Open STS.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Browse to the extracted `provider-consumer-sts-project` folder.
5. Select the root `pom.xml` and click **Finish**.
6. Wait for Maven dependencies to download.

## Run
Start the provider first:
1. Open `ProductProviderApplication.java`.
2. Right-click → **Run As → Spring Boot App**.

Then start the consumer:
1. Open `OrderConsumerApplication.java`.
2. Right-click → **Run As → Spring Boot App**.

## Test GET requests
Provider direct:
`http://localhost:8081/products/101`

Consumer calling provider:
`http://localhost:8082/orders/product/101`

Expected JSON:
```json
{
  "id": 101,
  "name": "Laptop",
  "description": "Business laptop",
  "price": 55000.0
}
```

Other provider IDs: 102 and 103. Unknown IDs return HTTP 404.

## Notes
- This is a runnable two-service Spring Boot example, not a Kubernetes deployment.
- The YAML contract is a readable API contract/specification. It is not automatically executed by Spring Cloud Contract.
- The consumer uses a configurable provider URL in `order-consumer/src/main/resources/application.properties`.
