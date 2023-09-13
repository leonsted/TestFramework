package tests.web;

import config.App;
import helpers.AllureRestAssuredFilter;
import tests.TestBase;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Story("Google tests")
public class logTest extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = App.config.apiUrl();
        Configuration.baseUrl = App.config.webUrl();
    }

    @Test
    @Tag("web")
    @DisplayName("Successful authorization to some google (UI)")
    void loginTest() {
        step("Fill search query", () -> {
            open("/");
            $x("/html/body/div[1]/div[2]/div/img").isImage();
            $x("/html/body/div[1]/div[2]/div/img").isDisplayed();

        });
    }
}