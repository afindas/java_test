import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/** FR-058 BE-05 -- CLAP-generated for module: Posts */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostsApiTest {

    @BeforeAll static void setup() {
        RestAssured.baseURI = "{{BASE_URL}}";
    }

    @Order(1)
    @Test void get_all_posts() {
        ```java
        @Test
        public void testGetPosts() {
            given()
                .when()
                    .get("/posts")
                .then();
        }
        ```
    }

    @Order(2)
    @Test void create_a_new_post() {
        ```java
        @Test
        public void testPostPosts() {
            String requestBody = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        
            given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .post("/posts")
            .then();
        }
        ```
    }

    @Order(3)
    @Test void update_existing_post() {
        ```java
        @Test
        public void testPutPost() {
            String requestBody = "{\"id\":1,\"title\":\"updated\",\"body\":\"bar\",\"userId\":1}";
        
            given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .put("/posts/1")
            .then();
        }
        ```
    }

    @Order(4)
    @Test void delete_a_post() {
        ```java
        @Test
        public void testDeletePost() {
            given()
                .when()
                .delete("/posts/1")
                .then();
        }
        ```
    }

}
