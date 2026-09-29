import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/** FR-058 BE-05 -- CLAP-generated for module: Comments */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommentsApiTest {

    @BeforeAll static void setup() {
        RestAssured.baseURI = "{{BASE_URL}}";
    }

    @Order(1)
    @Test @Disabled("FR-058 BE-05: CLAP generation failed -- CLAP call failed: ERR-003-PROVIDER_ERROR: Claude client error: 400 BAD_REQUEST — {'type':'error','error':{'type':'invalid_request_error','message':'You have reached your specified API usage limits. You will regain access on 2026-10-01 at 00:00 UTC.'},'request_id':'req_011CfXJuJsCRt3Kp3Sjs8fTj'}") void get_comments_for_a_post() {
        // generation failed for this TC, see @Disabled reason
    }

    @Order(2)
    @Test @Disabled("FR-058 BE-05: CLAP generation failed -- CLAP call failed: ERR-003-PROVIDER_ERROR: Claude client error: 400 BAD_REQUEST — {'type':'error','error':{'type':'invalid_request_error','message':'You have reached your specified API usage limits. You will regain access on 2026-10-01 at 00:00 UTC.'},'request_id':'req_011CfXJue573bKDJk5cqf1Ha'}") void filter_comments_by_postid() {
        // generation failed for this TC, see @Disabled reason
    }

}
