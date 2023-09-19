package tests.api;

import com.codeborne.selenide.Configuration;
import config.App;
import helpers.AllureRestAssuredFilter;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ApiTest {
    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = App.config.apiUrl();
    }

    @Test
    @Tag("api")
    @Tag("smoke")
    void apiTest() {
        step("Get cookie by api and set it to browser", () -> {
            String authorizationCookie =
                    given()
                            .filter(AllureRestAssuredFilter.withCustomTemplates())
                            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                            .when()
                            .get("/pet/0")
                            .then()
                            .statusCode(404)
                            .extract()
                            .cookie("NOPCOMMERCE.AUTH");
        });
    }
}
