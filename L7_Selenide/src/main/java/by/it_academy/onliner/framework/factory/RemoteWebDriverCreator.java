package by.it_academy.onliner.framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

import static by.it_academy.onliner.framework.factory.ConfigReader.getConfigProperty;
import static by.it_academy.onliner.framework.factory.ConfigReader.getConfigURL;

public class RemoteWebDriverCreator implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String driverType = System.getProperty("driverType");
        if (driverType != null) {
            capabilities.setBrowserName(driverType);
        } else {
            capabilities.setBrowserName(getConfigProperty("driverType"));
        }
        capabilities.setCapability("os", getConfigProperty("os.type"));
        capabilities.setCapability("os_version", getConfigProperty("os.version"));
        URL gridURL = getConfigURL("grid.url");
        return new RemoteWebDriver(gridURL, capabilities);
    }
}

