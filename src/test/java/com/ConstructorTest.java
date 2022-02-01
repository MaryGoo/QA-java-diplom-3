package com;

import com.model.User;
import com.page.LoginPage;
import com.page.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.page.LoginPage.LOGIN_PAGE_URL;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
    MainPage mainPage = page(MainPage.class);

    User user;
    UserOperations userOperations = new UserOperations();

    @Before
    public void setUp() {
    BaseTest.setUpForAll();
        user = new User(userOperations.register());
        loginPage.login(user);
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @DisplayName("При попадании на главную страницу по дефолту открыта вкладка Булки")
    @Test
    public void BunsTabTest() {
        boolean isBun = mainPage.checkTopBun();
        assertTrue("Булки нет!", isBun);
    }

    @DisplayName("Успешный переход на вкладку Соусы")
    @Test
    public void GoSauceTabTest() {
        mainPage.clickSauce();
        boolean isSauce = mainPage.checkTopSauce();
        assertTrue("Соусов нет!", isSauce);
    }

    @DisplayName("Успешный переход на вкладку начинки")
    @Test
    public void GoToppingTabTest() {
        mainPage.clickToppings();
        boolean isTopping = mainPage.checkTopTopping();
        assertTrue("Начинок нет!", isTopping);
    }

    @DisplayName("Успешный переход на вкладку Булки из других вкладок")
    @Test
    public void GoBunTabTest() {
        mainPage.clickToppings();
        mainPage.clickBuns();
        boolean isBun = mainPage.checkTopBun();
        assertTrue("Булки нет!", isBun);
    }
}
