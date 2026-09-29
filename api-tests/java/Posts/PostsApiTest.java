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
    @Test void get_single_post_by_id() {
        ```java
        @Test
        public void testGetPostById_VerifyAllPostFieldsArePresent() {
            given()
                .header("Accept", "application/json")
            .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
            .then()
                .statusCode(200)
                .body("$.id", equalTo(1))
                .body("$.userId", notNullValue())
                .body("$.title", notNullValue())
                .header("Content-Type", notNullValue())
                .time(lessThan(2000L), TimeUnit.MILLISECONDS);
        }
        ```
    }

    @Order(2)
    @Test void list_all_posts() {
        ```java
        @Test
        public void testGetPostsEndpoint() {
            Response response =
                given()
                    .header("Accept", "application/json")
                .when()
                    .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .statusCode(200)
                    .body("userId", everyItem(notNullValue()))
                    .time(lessThan(3000L), TimeUnit.MILLISECONDS)
                    .extract().response();
        
            // CLAP hint: Assert response is a non-empty array
            List<?> responseList = response.jsonPath().getList("$");
            Assert.assertNotNull(responseList, "Response array should not be null");
            Assert.assertFalse(responseList.isEmpty(), "Response array should not be empty");
        }
        ```
    }

    @Order(3)
    @Test void filter_posts_by_userid() {
        ```java
        @Test
        public void testGetPostsByUserId() {
            Response response = given()
                    .header("Accept", "application/json")
                .when()
                    .get("https://jsonplaceholder.typicode.com/posts?userId=1")
                .then()
                    .statusCode(200)
                    .body(containsString("\"userId\": 1"))
                    .extract()
                    .response();
        
            // CLAP hint: Every item should have userId = 1
            List<Integer> userIds = response.jsonPath().getList("userId");
            org.testng.Assert.assertNotNull(userIds, "Response body should contain a list of posts");
            org.testng.Assert.assertFalse(userIds.isEmpty(), "Posts list should not be empty");
            for (Integer userId : userIds) {
                org.testng.Assert.assertEquals(
                        userId.intValue(),
                        1,
                        "Every post should have userId = 1, but found userId = " + userId
                );
            }
        }
        ```
    }

    @Order(4)
    @Test void get_post_non_existent_id() {
        ```java
        @Test
        public void testGetNonExistentPostReturns404() {
            given()
                .header("Accept", "application/json")
            .when()
                .get("https://jsonplaceholder.typicode.com/posts/99999")
            .then()
                .statusCode(404);
        }
        ```
    }

    @Order(5)
    @Test void create_new_post() {
        ```java
        @Test
        public void testCreatePost() {
            String requestBody = "{"
                    + "\"title\":\"ICE API test\","
                    + "\"body\":\"Created by FR-058 import\","
                    + "\"userId\":1"
                    + "}";
        
            given()
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .header("Accept", "application/json")
                    .body(requestBody)
            .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
            .then()
                    .statusCode(201)
                    .body("$.id", equalTo(101))
                    .body("$.title", equalTo("ICE API test"))
                    .body("$.userId", equalTo(1));
        }
        ```
    }

    @Order(6)
    @Test void update_post_put() {
        ```java
        @Test
        public void testPutPost1_FullReplacement() {
            String requestBody = "{"
                    + "\"id\":1,"
                    + "\"title\":\"Updated title\","
                    + "\"body\":\"Updated body\","
                    + "\"userId\":1"
                    + "}";
        
            given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("Accept", "application/json")
                .body(requestBody)
            .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
            .then()
                .statusCode(200)
                .body("$.title", equalTo("Updated title"))
                .body("$.id", equalTo(1));
        }
        ```
    }

    @Order(7)
    @Test void partial_update_post_patch() {
        ```java
        @Test
        public void testPatchPost() {
            String requestBody = "{\"title\":\"Patched title\"}";
        
            given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("Accept", "application/json")
                .body(requestBody)
            .when()
                .patch("https://jsonplaceholder.typicode.com/posts/1")
            .then()
                .statusCode(200)
                .body("$.title", equalTo("Patched title"))
                .body("$.body", notNullValue());
        }
        ```
    }

    @Order(8)
    @Test void delete_post() {
        ```java
        @Test
        public void testDeletePost1() {
            given()
                .header("Accept", "application/json")
            .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
            .then()
                .statusCode(200)
                .time(lessThan(3000L), TimeUnit.MILLISECONDS)
                .body(equalTo("{}"));
        }
        ```
    }

}
