package tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import models.SuccessfulRegisterBodyModel;
import models.SuccessfulRegisterResponseModel;
import models.UnsuccessfulRegisterBodyModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.RegisterSpecs.getResponseSpecification;
import static specs.RegisterSpecs.loginRequestSpec;

@Tag("Api")
public class RegisterSpecModelTests extends TestBase {

    @Test
    @DisplayName("Проверка успешной авторизации")
    void successRegisterTest() {

        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("eve.holt@reqres.in", "pistol");
        SuccessfulRegisterResponseModel response = step("Успешная регистрация: ввод email и пароля", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(200))
                        .extract().as(SuccessfulRegisterResponseModel.class));
        step("Проверка ответа", () ->
                assertNotNull(response.getToken()));
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации. Отсутствует email и пароль")
    void unsuccessRegister400Test() {

        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("", "");
        UnsuccessfulRegisterBodyModel response = step("Авторизация: отсутсвует email и пароль", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(400))
                        .extract().as(UnsuccessfulRegisterBodyModel.class));
        step("Проверка ответа", () ->
                assertEquals("Missing email or username", response.getError()));
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации. Невалидный email")
    void userNotRegisterTest() {

        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("eveasdas.holt@reqres.in", "pistol");
        UnsuccessfulRegisterBodyModel response = step("Авторизация с невалидным email", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(400))
                        .extract().as(UnsuccessfulRegisterBodyModel.class));
        step("Проверка ответа", () ->
                assertEquals("Note: Only defined users succeed registration", response.getError()));
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации. Отсутствует email")
    void missingLoginTest() {
        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("", "pistol");
        UnsuccessfulRegisterBodyModel response = step("Авторизация с пропущенным email", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(400))
                        .extract().as(UnsuccessfulRegisterBodyModel.class));
        step("Проверка ответа", () ->
                assertEquals("Missing email or username", response.getError()));
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации. Невалидный пароль")
    void errorPasswordTest() {
        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("eve.holt@reqres.in", "pistolet");
        SuccessfulRegisterResponseModel response = step("Авторизация с невалидным паролем", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(200))
                        .extract().as(SuccessfulRegisterResponseModel.class));
        step("Проверка ответа", () ->
                assertNotNull(response.getToken()));
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации. Отсутствует пароль")
    void missingPasswordTest() {
        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("eve.holt@reqres.in", "");
        UnsuccessfulRegisterBodyModel response = step("Авторизация с пропущенным паролем", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(400))
                        .extract().as(UnsuccessfulRegisterBodyModel.class));

        step("Проверка ответа", () ->
                assertEquals("Missing password", response.getError()));
    }
    @Test
    @DisplayName("Проверка неуспешной авторизации. Невалидные данные в email и пароле")
    void wrongBodyTest() {
        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("%}", "%}");
        UnsuccessfulRegisterBodyModel response = step("Авторизация с пропущенным паролем", () ->
                given(loginRequestSpec)
                        .body(registerData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(getResponseSpecification(400))
                        .extract().as(UnsuccessfulRegisterBodyModel.class));
        step("Проверка ответа", () ->
                assertNotNull(response.getError()));
    }
}