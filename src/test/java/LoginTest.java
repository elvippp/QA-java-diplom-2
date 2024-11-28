import Models.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest {

    private Helper helper;
    private String accessToken;

    @Before
    public void setUp(){
        helper = new Helper();
    }
    @After
    public void tearDown() {
        if (accessToken != null && !accessToken.isEmpty()) {
            helper.deleteUserByToken(accessToken);
        }
    }

    @Test
    @Description("Получение логина существующего пользователя")
    public void loginUser(){
        // создание пользователя
       User user = helper.generateRandomUser();
       Response registerUserResponse = helper.createUniqueUser(user);
       accessToken = helper.verifyUserCreation(registerUserResponse, user);

        Response loginUserResponse = helper.loginWithUser(user);
        accessToken = helper.verifyLoginSuccess(loginUserResponse);

    }

    @Test
    @Description("Получение логина с незаполненным полем email")
    public void incorrectEmailUser() {
        User user = helper.generateRandomUser();
        user.setEmail("fgkkf");
        Response inccorectEmailResponse = helper.loginWithUser(user);
        helper.verifyLoginWithInvalidCredentials(inccorectEmailResponse);
        }

    @Test
    @Description("Получение логина с незаполненным полем password")
    public void incorrectPasswordUser() {
        User user = helper.generateRandomUser();
        user.setPassword("тим");
        Response inccorectEmailResponse = helper.loginWithUser(user);
        helper.verifyLoginWithInvalidCredentials(inccorectEmailResponse);
    }
}

