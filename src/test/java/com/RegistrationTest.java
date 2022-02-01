package com;

import com.BaseTest;
import com.model.User;
import com.page.LoginPage;
import com.page.MainPage;
import com.page.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

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
    public void registrationEmptyFormFail() {
        userFake = new User();
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустыми полями
        registerPage.checkError();
        registerPage.checkHeader();
    }

    @DisplayName("Не успешная регистрация с пустым Email")
    @Test
    public void registrationEmptyEmailFail() {
        userFake = new User().getRandom(6);
        userFake.setEmail("");
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустым Email
        registerPage.checkError();
        registerPage.checkHeader();
    }

    @DisplayName("Не успешная регистрация с пустым Name")
    @Test
    public void registrationEmptyNameFail() {
        userFake = new User().getRandom(6);
        userFake.setName("");
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустым Name
        registerPage.checkError();
        registerPage.checkHeader();
    }

    @DisplayName("Не успешная регистрация с пустым Name")
    @Test
    public void registrationEmptyPasswordFail() {
        userFake = new User().getRandom(6);
        userFake.setPassword("");
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        //TODO завести дефек: нет ошибки при попытке регистрации с пустым Password
        registerPage.checkError();
        registerPage.checkHeader();
    }

    @DisplayName("Успешная регистрация с паролем 6 символов")
    @Test
    public void registrationWithPass6CharSuccess() {
        userFake = new User().getRandom(6);
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        loginPage.login(userFake);
        mainPage.checkHasButtonAndText();
    }

    @DisplayName("Не успешная регистрация с паролем 5 символов")
    @Test
    public void registrationWithPass5CharFail() {
        userFake = new User().getRandom(5);
        mainPage.clickSingIn();
        loginPage.clickRegister();
        registerPage.fillRegisterForm(userFake);
        registerPage.clickRegButton();
        registerPage.checkError();
        registerPage.checkHeader();
    }
}