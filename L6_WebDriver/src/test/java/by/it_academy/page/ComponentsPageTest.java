package by.it_academy.page;

import by.it_academy.webdriver.DriverCreator;
import by.it_academy.webdriver.DriverNavigator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ComponentsPageTest {
    private static final String CHROME = "chrome";
    private static final String OPERA = "opera";
    private static final String PATTERN_QUANTITY_OF_PRODUCTS_AVAILABLE = "[\\d]+\\s(товар)";
    private static final String PATTERN_MIN_PRICE_OF_PRODUCT = "(от)\\s\\d+[.,]?[0-9]+\\s(р)";
    private static final String TOP_MENU_SECTION_NAME = "Каталог";
    private static final String SUBSECTION_NAME = "Компьютеры и";
    private static final String LEFT_MENU_ITEM_NAME = "Комплектующие";
    private static ComponentsPage componentsPage = new ComponentsPage();

    @BeforeClass
    public static void getOnlinerGetCatalogGetComputersGetComponents() {
        DriverCreator driver = DriverNavigator.getWebDriverByType(CHROME).getWebDriver();
        componentsPage = OnlinerPageNavigation.navigateToFirstPage()
                .clickOnCatalog(TOP_MENU_SECTION_NAME)
                .clickOnComputers(SUBSECTION_NAME)
                .clickOnComponents(LEFT_MENU_ITEM_NAME);
    }

    @Test
    public void testAllElementsContainName() {
        List<WebElement> targetWebElementsWithNames = componentsPage.findElements(By.xpath(PathNames.COMPONENTS_NAME_LOCATOR));
        List<String> actualWebElementsWithNames = componentsPage.findProductNames();
        assertThat(targetWebElementsWithNames).hasSameSizeAs(actualWebElementsWithNames);
    }

    @Test
    public void testAllElementsContainDescriptionQuantity() {
        List<WebElement> targetWebElementsWithDescriptionsQuantity
                = componentsPage.findElements(By.xpath(PathNames.COMPONENTS_DESCRIPTION_LOCATOR));
        List<String> descriptionsList = componentsPage.findProductDescriptions();
        Pattern pattern = Pattern.compile(PATTERN_QUANTITY_OF_PRODUCTS_AVAILABLE);
        List<String> actualList = descriptionsList.stream().filter(pattern.asPredicate()).collect(Collectors.toList());
        assertThat(targetWebElementsWithDescriptionsQuantity).hasSameSizeAs(actualList);
    }


    @Test
    public void testAllElementsContainDescriptionMinPrice() {
        List<WebElement> targetWebElementsWithDescriptionsMinPrice
                = componentsPage.findElements(By.xpath(PathNames.COMPONENTS_DESCRIPTION_LOCATOR));
        List<String> descriptionsList = componentsPage.findProductDescriptions();
        Pattern pattern = Pattern.compile(PATTERN_MIN_PRICE_OF_PRODUCT);
        List<String> actualList = descriptionsList.stream().filter(pattern.asPredicate()).collect(Collectors.toList());
        assertThat(targetWebElementsWithDescriptionsMinPrice).hasSameSizeAs(actualList);
    }

    @AfterClass
    public static void closeAllWindows() {
        componentsPage.closeBrowser();
    }
}

