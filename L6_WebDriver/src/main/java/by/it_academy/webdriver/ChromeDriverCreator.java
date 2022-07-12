package by.it_academy.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements DriverCreator {
    private WebDriver driver;

    public ChromeDriverCreator() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
