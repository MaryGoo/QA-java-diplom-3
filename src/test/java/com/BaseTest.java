package com;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    static void setUpForAll() {
        Configuration.startMaximized = true;
        //в Configurations надо указать в каком браузере запускать тесты: -Dbrowser=ya или пусто. по умолчанию будет chrome
        if (System.getProperty("browser") == "ya") {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        }
    }
}