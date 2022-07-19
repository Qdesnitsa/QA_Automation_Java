package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;

public class OnlinerPage extends BasePage {

    public CatalogPage clickOnCatalog(String linkContains) {
        waitForElementVisible(By.xpath(String.format(PathName.CATALOG, linkContains))).click();
        return new CatalogPage();
    }
}
