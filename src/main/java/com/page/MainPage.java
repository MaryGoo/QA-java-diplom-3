package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    //кнопка Войти в аккаунт(переход к странице логина)
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement signIn;
    //Надпись Соберите бургер
    @FindBy(how = How.CSS,using = ".text.text_type_main-large.mb-5.mt-10")
    private SelenideElement inscriptionBurger;
    //кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement makeOrderButton;
    //Кнопка личный кабинет
    @FindBy(how = How.XPATH, using = "//*[text()='Личный Кабинет']")
    public SelenideElement personalAccount;
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Лента Заказов')]")
    public SelenideElement goOrderfeed;
    //Переход на булки
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Булки')]")
    private SelenideElement bunsTab;
    //Подзаголовок Н2 Булки
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Булки')]")
    private SelenideElement fluorBun;
    //Переход на соусы
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Соусы')]")
    private SelenideElement sauceTab;
    //Подзаголовок Н2 Соусы
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Соусы')]")
    private SelenideElement sauce;
    //Переход на начинки
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Начинки')]")
    private SelenideElement toppingsTab;
    //Первая начинка в списке для проверки, что перешли на начинки
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Начинки')]")
    private SelenideElement toppings;
    //Модалка заказа
    @FindBy(how = How.XPATH,using = "//div[@class='Modal_modal__contentBox__sCy8X pt-30 pb-30']")
    private SelenideElement modale;
    //Закрытие модалки
    @FindBy(how = How.XPATH,using = "//div[@class='Modal_modal__contentBox__sCy8X pt-30 pb-30']")
    private SelenideElement close;

    @Step("Получить текст кнопки Оформить заказ")
    public String getTextMakeOrderButton(){
        return makeOrderButton.getText();
    }
    @Step("Получить текст надписи Соберите бургер")
    public String getTextInscriptionBurger(){
        return inscriptionBurger.getText();
    }

    @Step("Нажать кнопку Войти в аккаунт")
    public void clickSingIn() {
        signIn.shouldBe(Condition.exist).click();
    }

    @Step("Нажать кнопку Личный кабинет")
    public void clickPersAcc() {
        personalAccount.shouldBe(Condition.exist).click();
    }

    @Step("Нажать вкладку Булки")
    public void clickBuns() {
        bunsTab.shouldBe(Condition.exist).click();
    }

    @Step("Найти Подзаголовок Н2 Булки")
    public SelenideElement findFluorBun(){
        return fluorBun;
    }

    @Step("Нажать вкладку Соусы")
    public void clickSauce() {
        sauceTab.shouldBe(Condition.exist).click();
    }

    @Step("Найти подзаголовок Соусы")
    public SelenideElement findSauce(){
        return sauce;
    }

    @Step("Нажать вкладку Начинки")
    public void clickToppings() {
        toppingsTab.shouldBe(Condition.exist).click();
    }

    @Step("Найти Начинку")
    public SelenideElement findToppings(){
        return toppings;
    }
}