package by.it_academy.page;

import org.openqa.selenium.By;

public class OnlinerPage extends BasePage {

    public CatalogPage clickOnCatalog(String linkContains) {
        waitForElementVisible(By.xpath(String.format(PathNames.CATALOG, linkContains))).click();
        return new CatalogPage();
    }
}
