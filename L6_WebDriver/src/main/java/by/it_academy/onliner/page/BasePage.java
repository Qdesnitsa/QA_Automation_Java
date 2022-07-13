package by.it_academy.onliner.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {
    private static final int DRIVER_WAIT_TIME = 30;
    public static WebDriver driver;

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, (long) DRIVER_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT_TIME);
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (RuntimeException timeoutException) {
            System.out.println("Failed attempt to get visibility of elements.");
        }
        return Collections.emptyList();
    }

    public List<String> getTextsFromWebElements(List<WebElement> webElements) {
        List<String> textFromWebElements = new ArrayList<>();
        webElements.forEach(element -> textFromWebElements.add(element.getText()));
        return textFromWebElements;
    }

    public String getTextFromWebElement(WebElement webElement) {
        return webElement.getText();
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            throw new RuntimeException("Failed attempt to close browser");
        }
    }
}
