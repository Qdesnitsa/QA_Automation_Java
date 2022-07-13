package by.it_academy.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverCreator implements DriverCreator {
    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        return driver = new OperaDriver();
    }
}
