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

//    //Поле ввода имени неактивное
//    @FindBy(how = How.XPATH,using = "//fieldset[1]//div[1]//div[1]")
//    private SelenideElement nameField;
//
//    //поле ввода имени активное
//    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
//    private SelenideElement nameActField;
//
//    //поле ввода мейла неактивное
//    @FindBy(how = How.XPATH,using = "//fieldset[2]//div[1]//div[1]")
//    private SelenideElement mailField;
//
//    //поле ввода мейла активное
//    @FindBy(how = How.CSS,using = "div[class='input pr-6 pl-6 input_type_text input_size_default input_status_active'] input[name='name']")
//    private SelenideElement mailActivField;
//
//    //поле ввода пароля неактивное
//    @FindBy(how = How.XPATH,using = "//fieldset[3]//div[1]//div[1]")
//    private SelenideElement passField;
//
//    //поле ввода пароля активное
//    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/input[1]")
//    private SelenideElement passActiveField;

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

    @Step
    public void fillRegisterForm(User user) {
        nameInput.setValue(user.getName());
        emailInput.setValue(user.getEmail());
        passwordInput.setValue(user.getPassword());
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegButton() {
        regButton.click();
    }

    @Step
    public void checkError() {
        error.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    @Step
    public void checkHeader() {
        registerHeader.shouldHave(Condition.exactText("Регистрация"));
    }

    @Step
    public void clickSingInButton() {
        singIn.shouldBe(Condition.exist).click();
    }

}
