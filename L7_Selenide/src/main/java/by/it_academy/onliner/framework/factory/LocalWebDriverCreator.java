package by.it_academy.onliner.framework.factory;

import by.it_academy.onliner.framework.webdriver.DriverNavigator;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public class LocalWebDriverCreator implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        String driverType = System.getProperty("driverType");
        return DriverNavigator.getWebDriverByType(driverType).create();
    }
}
