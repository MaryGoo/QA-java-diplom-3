package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //Input для поля Имя
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/../input")
    private SelenideElement nameInput;
    //Input для поля Email
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/../input")
    private SelenideElement emailInput;
    //Input для поля Пароль
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/../input")
    private SelenideElement passwordInput;
    //ошибка ввода пароля при нажатии на кнопку регистрации
    @FindBy(how = How.CSS, using = ".input__error.text_type_main-default")
    private SelenideElement error;
    //заголовок Регистрация
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Регистрация')]")
    private SelenideElement registerHeader;
    //кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement regButton;
    //кнопка Войти
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
    public SelenideElement singIn;

    @Step ("Заполнить имя, почту, пароль на форме регистрации")
    public void fillRegisterForm(User user) {
        nameInput.setValue(user.getName());
        emailInput.setValue(user.getEmail());
        passwordInput.setValue(user.getPassword());
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegButton() {
        regButton.click();
    }

    @Step("Проверить наличие ошибки \"Некорректный пароль\"")
    public void checkError() {
        error.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    @Step("Проверить наличие заголовка \"Регистрация\"")
    public void checkHeader() {
        registerHeader.shouldHave(Condition.exactText("Регистрация"));
    }

    @Step("Нажать на кнопку Войти")
    public void clickSingInButton() {
        singIn.shouldBe(Condition.exist).click();
    }
}