package by.it_academy.page;

import org.openqa.selenium.By;

import java.util.List;

public class CatalogPage extends BasePage {
    public List<String> catalogLinks() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(PathNames.CATALOG_TOP_MENU)));
    }

    public ComputersAndNetworksPage clickOnComputers(String linkContains) {
        waitForElementVisible(By.xpath(String.format(PathNames.COMPUTERS_AND_SMTH, linkContains))).click();
        return new ComputersAndNetworksPage();
    }
}
