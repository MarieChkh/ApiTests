package tests;

import models.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.RegisterSpecs.getResponseSpecification;
import static specs.RegisterSpecs.loginRequestSpec;

@Tag("Api")
public class OthersSpecModelTests extends TestBase {
    @Test
    void updatePutTest() {
        UpdateUserModel updateUserData = new UpdateUserModel("morpheus", "zion resident");
        SuccessfulUpdateResponseModel response = step("Корретное обновление имени и работы пользователя", () ->
                given(loginRequestSpec)
                        .body(updateUserData)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(getResponseSpecification(200))
                        .extract().as(SuccessfulUpdateResponseModel.class));
        step("Проверка ответа", () -> {
            assertEquals("morpheus",response.getName());
            assertEquals("zion resident",response.getJob());
        });
    }

    @Test
    void NotUpdatePutTest() {
        UpdateUserModel updateUserData = new UpdateUserModel("%}", "");
        SuccessfulUpdateResponseModel response = step("Невалидные данные пользователя в апдейте", () ->
                given(loginRequestSpec)
                        .body(updateUserData)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(getResponseSpecification(200))
                        .extract().as(SuccessfulUpdateResponseModel.class));
        step("Проверка ответа", () -> {
            assertNotNull(response.getName());
        });
    }

    @Test
    void UpdatePatchTest() {
        UpdateUserModel updateUserData = new UpdateUserModel("morpheus", "zion resident");
        SuccessfulUpdateResponseModel response = step("Корретное обновление имени и работы пользователя(patch)", () ->
                given(loginRequestSpec)
                        .body(updateUserData)
                        .when()
                        .patch("/users/2")
                        .then()
                        .spec(getResponseSpecification(200))
                        .extract().as(SuccessfulUpdateResponseModel.class));
        step("Проверка ответа", () -> {
            assertEquals("morpheus",response.getName());
            assertEquals("zion resident",response.getJob());
        });
    }
}