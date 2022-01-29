package com.page;

import io.qameta.allure.Step;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.page.MainPage.MAIN_PAGE_URL;

public class PrivateOfficePage {

    public final static String PRIVATE_OFFICE_PAGE_URL = MAIN_PAGE_URL + "/account/profile";

    //Кнопка Лого Бургера
    @FindBy(how = How.XPATH,using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    private SelenideElement logoBurger;
    //Надпись В этом разделе вы можете изменить свои персональные данные
    @FindBy(how = How.CLASS_NAME,using = "Account_list__3KQQf mb-20")
    private SelenideElement text;
    //Кнопка Выход
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Выход')]")
    private SelenideElement exitButton;
    //Кнопка Конструктор
    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;
    //Поле имя
    @FindBy(how = How.XPATH,using = "//input[@name='Name']")
    private SelenideElement nameField;

    @Step("Получить значение поля Имя")
    public String getNameValue() {
        return nameField.getAttribute("value");
    }

    @Step("Нажать кнопку Конструктор")
    public void clickConstructorButton() {
        constructorButton.shouldBe(Condition.exist).click();
    }

    @Step("Нажать Лого Бургера")
    public void clickBurger() {
        logoBurger.shouldBe(Condition.exist).click();
    }

    @Step("Нажать кнопку Выход")
    public void clickExitButton() {
        exitButton.shouldBe(Condition.exist).click();
    }

    @Step("Получить текст надптси \"В этом разделе вы можете изменить свои персональные данные\"")
    public void getText() {
        text.shouldBe(Condition.exactText("В этом разделе вы можете изменить свои персональные данные"));
    }
}
