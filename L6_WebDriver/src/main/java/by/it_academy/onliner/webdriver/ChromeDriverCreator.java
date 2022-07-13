package by.it_academy.onliner.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements DriverCreator {
    private WebDriver driver;

    @Override
    public WebDriver createDriver() {
        return driver = new ChromeDriver();
    }
}
