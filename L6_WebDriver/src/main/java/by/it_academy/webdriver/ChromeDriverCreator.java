package by.it_academy.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements DriverCreator {
    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
