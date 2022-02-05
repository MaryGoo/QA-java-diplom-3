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
import static org.junit.Assert.*;

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
    public void bunsTabTest() {
        assertTrue(mainPage.findFluorBun().exists());
        assertTrue(mainPage.findFluorBun().isDisplayed());
    }

    @DisplayName("Успешный переход на вкладку Соусы")
    @Test
    public void goSauceTabTest() {
        mainPage.clickSauce();
        assertTrue(mainPage.findSauce().isDisplayed());
    }

    @DisplayName("Успешный переход на вкладку начинки")
    @Test
    public void goToppingTabTest() {
        mainPage.clickToppings();
        assertTrue(mainPage.findToppings().isDisplayed());
    }

    @DisplayName("Успешный переход на вкладку Булки из других вкладок")
    @Test
    public void goBunTabTest() {
        mainPage.clickToppings();
        mainPage.clickBuns();
        assertTrue(mainPage.findFluorBun().exists());
        assertTrue(mainPage.findFluorBun().isDisplayed());
    }
}
