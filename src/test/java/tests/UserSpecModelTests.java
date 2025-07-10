package tests;
import models.CreateUserModel;
import models.UpdateUserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RegisterSpecs.getResponseSpecification;
import static specs.RegisterSpecs.loginRequestSpec;

@Tag("Api")
public class UserSpecModelTests extends TestBase {
    @Test
    @DisplayName("Успешное удаление пользователя")

    void deleteNewUserTest() {

        UpdateUserModel updateUserData = new UpdateUserModel("Test", "super");

        CreateUserModel response = step("Отправить POST запрос на создание нового пользователя", () ->
                given(loginRequestSpec)
                        .body(updateUserData)
                        .contentType(JSON)
                        .when()
                        .post("/users")
                        .then()
                        .spec(getResponseSpecification(201))
                        .extract().as(CreateUserModel.class));

        step("Проверить ответ на запрос создание нового пользователя", () -> {
            assertEquals("Test",response.getName());
            assertEquals("super",response.getJob());
            assertThat(response.getId(), notNullValue());
        });

        int id = response.getId();

        step("Отправить DELETE запрос на удаление созданного пользователя с id = " + id, () ->
                given(loginRequestSpec)
                        .when()
                        .delete("/users" + id)
                        .then()
                        .spec(getResponseSpecification(204)));
    }
}