package by.it_academy.onliner.framework;

import by.it_academy.onliner.framework.factory.LocalWebDriverCreator;
import by.it_academy.onliner.framework.factory.RemoteWebDriverCreator;
import com.codeborne.selenide.Configuration;

public class SelenideWebDriverConfigurator {
    public void configure() {
        String remoteDriver = System.getProperty("isRemote");
        if(remoteDriver == null) {
            Configuration.browser = LocalWebDriverCreator.class.getName();
        }
        else if (remoteDriver.equals("true")) {
            Configuration.browser = RemoteWebDriverCreator.class.getName();
            return;
        } else {
            Configuration.browser = LocalWebDriverCreator.class.getName();
        }
    }
}
