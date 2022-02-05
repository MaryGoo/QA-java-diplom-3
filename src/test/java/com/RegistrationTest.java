package com;

import com.model.User;
import com.page.LoginPage;
import com.page.MainPage;
import com.page.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    User userFake;
    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegisterPage registerPage = page(RegisterPage.class);

    @Before
    public void setUp() {
        BaseTest.setUpForAll();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @DisplayName("Не успешная регистрация с пустой формой")
    @Test
    public void registrationEmptyFormFailTest() {
        userFake = new User();
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустыми полями
        assertEquals( "Текст ошибки не верен", "Некорректный пароль", registerPage.getTextError());
        assertEquals( "Надпить \"Регистрация\" не видна", "Регистрация", registerPage.getTextRegisterHeader());
    }

    @DisplayName("Не успешная регистрация с пустым Email")
    @Test
    public void registrationEmptyEmailFailTest() {
        userFake = new User().getRandom(6);
        userFake.setEmail("");
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустым Email
        assertEquals( "Текст ошибки не верен", "Некорректный пароль", registerPage.getTextError());
        assertEquals( "Надпить \"Регистрация\" не видна", "Регистрация", registerPage.getTextRegisterHeader());
    }

    @DisplayName("Не успешная регистрация с пустым Name")
    @Test
    public void registrationEmptyNameFailTest() {
        userFake = new User().getRandom(6);
        userFake.setName("");
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустым Name
        assertEquals( "Текст ошибки не верен", "Некорректный пароль", registerPage.getTextError());
        assertEquals( "Надпить \"Регистрация\" не видна", "Регистрация", registerPage.getTextRegisterHeader());
    }

    @DisplayName("Не успешная регистрация с пустым Name")
    @Test
    public void registrationEmptyPasswordFailTest() {
        userFake = new User().getRandom(6);
        userFake.setPassword("");
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустым Password
        assertEquals( "Текст ошибки не верен", "Некорректный пароль", registerPage.getTextError());
        assertEquals( "Надпить \"Регистрация\" не видна", "Регистрация", registerPage.getTextRegisterHeader());

    }

    @DisplayName("Успешная регистрация с паролем 6 символов")
    @Test
    public void registrationWithPass6CharSuccessTest() {
        userFake = new User().getRandom(6);
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        loginPage.login(userFake);
        assertEquals( "Кнока \"Оформить заказ\" не видна", "Оформить заказ", mainPage.getTextMakeOrderButton());
        assertEquals( "Надпить \"Соберите бургер\" не видна", "Соберите бургер", mainPage.getTextInscriptionBurger());
    }

    @DisplayName("Не успешная регистрация с паролем 5 символов")
    @Test
    public void registrationWithPass5CharFailTest() {
        userFake = new User().getRandom(5);
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        assertEquals( "Текст ошибки не верен", "Некорректный пароль", registerPage.getTextError());
        assertEquals( "Надпить \"Регистрация\" не видна", "Регистрация", registerPage.getTextRegisterHeader());
    }
}