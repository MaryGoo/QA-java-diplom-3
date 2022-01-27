import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.model.User;
import com.page.ForgotPasswordPage;
import com.page.LoginPage;
import com.page.MainPage;
import com.page.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class UserLoginTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegisterPage registerPage = page(RegisterPage.class);
    ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);

    User user;
    UserOperations userOperations = new UserOperations();

    @Before
    public void setUp (){
        BaseTest.setUpForAll();
        user=new User(userOperations.register());
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @DisplayName("Успешный логин при попадании на страницу логина через кнопку Войти в аккаунт")
    @Test
    public void loginMainPageWithSingInSuccessTest(){
        mainPage.clickSingIn();
        loginPage.login(user);
        mainPage.checkHasButtonAndText();
    }

    @DisplayName("Успешный логин при попадании на страницу логина через кнопку Личный кабинет")
    @Test
    public void loginMainPageWithWithPersonAccButtonSuccessTest(){
        mainPage.clickPersAcc();
        loginPage.login(user);
        mainPage.checkHasButtonAndText();
    }

    @DisplayName("Успешный логин при попадании на страницу логина из формы регистрации")
    @Test
    public void loginMainPageFromRegisterFormSuccessTest(){
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.clickSingInButton();
        loginPage.login(user);
        mainPage.checkHasButtonAndText();
    }

    @DisplayName("Успешный логин при попадании на страницу логина из формы восстановления пароля")
    @Test
    public void loginMainPageFromForgotPassFormSuccessTest(){
        mainPage.clickSingIn();
        loginPage.clickRestorePassword();
        forgotPasswordPage.clickSingInButton();
        loginPage.login(user);
        mainPage.checkHasButtonAndText();
    }
}