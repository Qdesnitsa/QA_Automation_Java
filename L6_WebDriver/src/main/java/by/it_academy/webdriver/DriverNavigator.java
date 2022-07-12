package by.it_academy.webdriver;

import by.it_academy.page.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public enum DriverNavigator {
    CHROME("chrome", new ChromeDriverCreator()),
    OPERA("opera", new OperaDriverCreator());

    private String driverType;
    private DriverCreator webDriver;

    DriverNavigator(String driverType, DriverCreator webDriver) {
        this.driverType = driverType;
        this.webDriver = webDriver;
    }

    public String getDriverType() {
        return driverType;
    }

    public DriverCreator getWebDriver() {
        return webDriver;
    }

    public static DriverNavigator getWebDriverByType(String driverType) {
        DriverNavigator driverNavigator = Arrays.stream(DriverNavigator.values())
                .filter(type -> type.getDriverType().equals(driverType))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Driver not found."));
        BasePage.driver = (WebDriver) driverNavigator.getWebDriver().getDriver();
        return driverNavigator;
    }

}
