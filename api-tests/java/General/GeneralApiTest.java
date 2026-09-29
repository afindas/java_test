import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/** FR-058 BE-05 -- CLAP-generated for module: General */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GeneralApiTest {

    @BeforeAll static void setup() {
        RestAssured.baseURI = "{{BASE_URL}}";
    }

    @Order(1)
    @Test void unknown_route_returns_404() {
        ```java
        @Test
        public void testInvalidEndpointReturns404() {
            given()
                .header("Accept", "application/json")
            .when()
                .get("https://jsonplaceholder.typicode.com/invalid-endpoint")
            .then()
                .statusCode(404);
        }
        ```
    }

}
