package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement singInButton;
//
//    //метод клика на кнопку Войти
//    public LoginPage clickLoginButton() {
//        $(loginButton).click();
//        return page(LoginPage.class);
//    }

//    //локатор кнопки Войти
//    @FindBy(how = How.XPATH,using = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
//    public SelenideElement singInButton;

    @Step ("Нажать кнопку Войти")
    public void clickSingInButton() {
        singInButton.shouldBe(Condition.exist).click();
    }
}
