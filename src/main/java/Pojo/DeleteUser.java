package Pojo;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteUser {

    private static final String DELETE = "https://stellarburgers.nomoreparties.site/api/auth/user";
    private static final String LOGIN = "https://stellarburgers.nomoreparties.site/api/auth/login";

    @Step("Удалить пользователя")
    public Response getDeleteUser(String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE);
    }

    @Step("Логин пользователя")
    public Response getDataUser(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(LOGIN);
    }

}
