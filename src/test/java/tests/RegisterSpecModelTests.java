package tests;

import models.SuccessfulRegisterBodyModel;
import models.SuccessfulRegisterResponseModel;
import models.UnsuccessfulRegisterBodyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
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
        @DisplayName("Проверка неуспешной авторизации. Невалидный пароль")
        void errorPasswordTest() {
            SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel("eve.holt@reqres.in", "pistolet");
            SuccessfulRegisterResponseModel response = step("Авторизация с невалидным паролем", () ->
                    given(loginRequestSpec)
                            .body(registerData)
                            .when()
                            .post("/register")
                            .then()
                            .spec(getResponseSpecification(200)) //это баг
                            .extract().as(SuccessfulRegisterResponseModel.class));
            step("Проверка ответа", () ->
                    assertNotNull(response.getToken()));
        }


    @ParameterizedTest(name = "Проверка получения ошибки при регистрации c невалидными mail {0}, password {1}")
    @CsvFileSource(resources = "/data.csv")
    void unsuccessfulRegistrationWithoutRequiredFieldsTest(String email, String password) {

        SuccessfulRegisterBodyModel registerData = new SuccessfulRegisterBodyModel(email, password);
        UnsuccessfulRegisterBodyModel response = step("Авторизация: невалидные данные  email и пароль", () ->
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