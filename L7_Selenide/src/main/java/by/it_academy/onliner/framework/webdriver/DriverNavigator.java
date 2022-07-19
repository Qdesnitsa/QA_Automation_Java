package by.it_academy.onliner.framework.webdriver;

import java.util.Arrays;

public enum DriverNavigator {
    CHROME("chrome", new ChromeDriverCreator()),
    OPERA("opera", new OperaDriverCreator());

    private String driverType;
    private WebDriverCreator webDriver;

    DriverNavigator(String driverType, WebDriverCreator webDriver) {
        this.driverType = driverType;
        this.webDriver = webDriver;
    }

    public String getDriverType() {
        return driverType;
    }

    public WebDriverCreator getWebDriver() {
        return webDriver;
    }

    public static WebDriverCreator getWebDriverByType(String driverType) {
        DriverNavigator driverNavigator = Arrays.stream(DriverNavigator.values())
                .filter(type -> type.getDriverType().equals(driverType))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Driver not found."));
        return driverNavigator.getWebDriver();
    }
}
