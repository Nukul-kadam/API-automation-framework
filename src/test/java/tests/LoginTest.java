package tests;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.*;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        test = extent.createTest("Login");

        String payload = "{ \"email\": \"" + TokenManager.randomEmail + "\", \"password\": \"password123\" }";

        String response = given()
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .post("http://localhost:8000/login")
        .then()
            .statusCode(200)
            .extract().asString();

        JsonPath jp = new JsonPath(response);
        TokenManager.accessToken = jp.getString("access_token");

        test.pass("Login successful. Token: " + TokenManager.accessToken);
    }
}
