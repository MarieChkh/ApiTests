package tests;

import models.*;
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
public class OthersSpecModelTests extends TestBase {
    @Test
    @DisplayName("Обновление и последующее удаление юзера")
    void updatePutAndDeleteTest() {
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
        step("Удаление юзера", () ->
                given(loginRequestSpec)
                        .when()
                        .delete("/users/2")

                        .then()
                        .spec(getResponseSpecification(204))
        );
    }

    @Test
    @DisplayName("Негативный сценарий: пользователь не обновлен")
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
    @DisplayName("Обновление пользователя")
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