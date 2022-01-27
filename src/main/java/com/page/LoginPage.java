package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.sleep;
import static com.page.MainPage.MAIN_PAGE_URL;

public class LoginPage {

    public final static String LOGIN_PAGE_URL =  MAIN_PAGE_URL + "/login";

    //Input для поля Email
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/../input")
    private SelenideElement emailInput;
    //Input для поля Пароль
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/../input")
    private SelenideElement passwordInput;


//    //поле мейла неактивное
//    @FindBy(how = How.CSS,using = ".input.pr-6.pl-6.input_type_text.input_size_default")
//    private SelenideElement emailField;
//
//    //поле мейла активное
//    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
//    private SelenideElement emailActField;
//
//    //Поле мейла для ввода
//    @FindBy(how = How.XPATH,using = "//input[@name='name']")
//    private SelenideElement emailInput;
//
//    //Поле пароля для ввода
//    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
//    private SelenideElement passwordInput;

    //Кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement entranceButton;

    //Ссылка на регистрацию
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement registerLink;

    //Ссылка на восстановление пароля
    @FindBy(how = How.LINK_TEXT,using = "Восстановить пароль")
    private SelenideElement restorePassword;

    //Переход в личный кабинет
    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement cabinet;

    //Переход к конструктору бургеров
    @FindBy(how = How.XPATH,using = "/p[contains(text(),'Конструктор')]")
    private SelenideElement constructor;

    //Переход к ленте заказов
    @FindBy(how = How.XPATH,using = "/p[contains(text(),'Лента Заказов')]")
    private SelenideElement orderTape;

    //Переход к конструктору через бургер
    @FindBy(how = How.XPATH,using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    private SelenideElement logoBurger;

    public LoginPage() {
    }

    @Step("Кликнуть на ссылку Зарегистрироваться")
    public void clickRegister() {
        registerLink.click();
    }

    @Step("Кликнуть на ссылку Восстановить пароль")
    public void clickRestorePassword(){
        restorePassword.click();
    }


    @Step
    public void login(User user){
        entranceButton.shouldBe(Condition.exist);
        emailInput.shouldBe(Condition.exist).setValue(user.getEmail());
        passwordInput.shouldBe(Condition.exist).setValue(user.getPassword());
        entranceButton.shouldBe(Condition.exist).click();
    }

    @Step
    public boolean checkEntrance() {
        if (entranceButton.isDisplayed());
        return true;
    }
}
