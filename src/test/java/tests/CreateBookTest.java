package tests;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.*;

public class CreateBookTest extends BaseTest {
    @Test
    public void createBookTest() {
        test = extent.createTest("Create Book");

        String payload = "{ \"name\": \"The Alchemists\", \"author\": \"Paulo Coelho\", " +
                "\"book_summary\": \"A story about following your dreams.\", \"published_year\": 1988 }";

        String response = given()
            .header("Authorization", "Bearer " + TokenManager.accessToken)
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .post("http://localhost:8000/books/")
        .then()
            .statusCode(200)
            .extract().asString();

        JsonPath jp = new JsonPath(response);
        TokenManager.bookId = jp.getString("id");

        test.pass("Book created with ID: " + TokenManager.bookId);
    }
}
