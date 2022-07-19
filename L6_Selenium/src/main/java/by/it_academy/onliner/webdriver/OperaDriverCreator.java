package by.it_academy.onliner.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverCreator implements DriverCreator {
    private WebDriver driver;

    @Override
    public WebDriver createDriver() {
        return driver = new OperaDriver();
    }
}
