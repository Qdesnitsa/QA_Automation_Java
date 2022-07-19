package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ComputersAndNetworksPage extends BasePage {
    public List<String> computersAndNetworksLinks() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(PathName.COMPUTERS_AND_NETWORKS_LIST_LEFT)));
    }

    public void mouseOver() {
        Actions action = new Actions(driver);
        waitForElementsVisible(By.xpath(PathName.NOTEBOOKS_COMPUTERS_MONITORS));
        WebElement webElement = findElement(By.xpath(PathName.NOTEBOOKS_COMPUTERS_MONITORS));
        action.moveToElement(webElement).build().perform();
    }

    public ComponentsPage clickOnComponents(String linkContains) {
        waitForElementVisible(By.xpath(String.format(PathName.COMPONENTS, linkContains))).click();
        return new ComponentsPage();
    }
}
