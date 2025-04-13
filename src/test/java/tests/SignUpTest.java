package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SignUpTest extends BaseTest {
    @Test
    public void signUpTest() {
        test = extent.createTest("Sign Up");

        RestAssured.baseURI = "http://localhost:8000";

        int rand = (int)(Math.random() * 100000);
        TokenManager.randomEmail = "test" + rand + "@example.com";

        String payload = "{ \"email\": \"" + TokenManager.randomEmail + "\", \"password\": \"password123\" }";

        given()
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .post("/signup")
        .then()
            .statusCode(200);

        test.pass("Signup successful for: " + TokenManager.randomEmail);
    }
}
