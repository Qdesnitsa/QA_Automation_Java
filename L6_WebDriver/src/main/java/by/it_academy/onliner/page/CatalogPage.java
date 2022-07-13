package by.it_academy.onliner.page;

import org.openqa.selenium.By;

import java.util.List;

public class CatalogPage extends BasePage {
    public List<String> catalogLinks() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(PathName.CATALOG_TOP_MENU)));
    }

    public ComputersAndNetworksPage clickOnComputers(String linkContains) {
        waitForElementVisible(By.xpath(String.format(PathName.COMPUTERS_AND_SMTH, linkContains))).click();
        return new ComputersAndNetworksPage();
    }
}
