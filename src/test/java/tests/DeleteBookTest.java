package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.*;

public class DeleteBookTest extends BaseTest {
    @Test
    public void deleteBookTest() {
        test = extent.createTest("Delete Book");

        given()
            .header("Authorization", "Bearer " + TokenManager.accessToken)
        .when()
            .delete("http://localhost:8000/books/" + TokenManager.bookId)
        .then()
            .statusCode(200);

        test.pass("Book deleted with ID: " + TokenManager.bookId);
    }
}
