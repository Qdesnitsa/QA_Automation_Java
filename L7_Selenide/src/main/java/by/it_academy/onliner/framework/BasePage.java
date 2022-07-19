package by.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;

public abstract class BasePage {
    public BasePage() {
        new SelenideWebDriverConfigurator().configure();
        Configuration.pageLoadTimeout = 200000;
        Configuration.startMaximized = true;
    }
}
