import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.model.User;
import com.page.LoginPage;
import com.page.MainPage;
import com.page.PrivateOfficePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrivateCabinetInTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    PrivateOfficePage privateOffice = page(PrivateOfficePage.class);
    LoginPage loginPage = page(LoginPage.class);
    UserOperations userOperations = new UserOperations();
    User user;

    @Before
    public void setUp() {
        BaseTest.setUpForAll();
        user = new User(userOperations.register());
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @DisplayName("Успешный переход в личный кабинет с главной страницы")
    @Test
    public void successInMainPrivateCabinetTest() {
        mainPage.clickSingIn();
        loginPage.login(user);
        mainPage.clickPersAcc();
        privateOffice.getNameValue();
        assertEquals(user.getName(), privateOffice.getNameValue());
    }

    @DisplayName("Успешный переход в конструктор из личного кабинета")
    @Test
    public void goInConstructorTest() {
        mainPage.clickSingIn();
        loginPage.login(user);
        mainPage.clickPersAcc();
        privateOffice.goConstr();
        mainPage.checkHasButtonAndText();
    }

    @DisplayName("Успешный переход в конструктор из личного кабинета через лого бургера")
    @Test
    public void goInBurgerLogoTest() {
        mainPage.clickSingIn();
        loginPage.login(user);
        mainPage.clickPersAcc();
        privateOffice.goBurger();
        mainPage.checkHasButtonAndText();
    }

    @DisplayName("Успешный выход из личного кабинета")
    @Test
    public void goExitTest() {
        mainPage.clickSingIn();
        loginPage.login(user);
        mainPage.clickPersAcc();
        privateOffice.goExit();
        assertTrue("Кнопки Войти нет на экране", loginPage.checkEntrance());
    }
}