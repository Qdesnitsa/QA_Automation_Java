package by.it_academy.onliner.page;

import by.it_academy.onliner.webdriver.DriverCreator;
import by.it_academy.onliner.webdriver.DriverNavigator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogPageTest {
    private static final String CHROME = "chrome";
    private static final String OPERA = "opera";
    private static final String TOP_MENU_SECTION_NAME = "Каталог";
    private static final List<String> SECTIONS_LIST = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника",
            "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");
    private static CatalogPage catalogpage = new CatalogPage();

    @BeforeClass
    public static void getOnlinerGetCatalog() {
        DriverCreator driver = DriverNavigator.getWebDriverByType(CHROME).getWebDriver();
        catalogpage = OnlinerPageNavigation.navigateToFirstPage()
                .clickOnCatalog(TOP_MENU_SECTION_NAME);
    }

    @Test
    public void testCatalogContainsSectionList() {
        System.out.println();
        List<String> sectionsTitles = catalogpage.catalogLinks();
        assertThat(isPageContainSectionList(sectionsTitles))
                .as("Page sections does not contain all items of target list")
                .isTrue();
    }

    public boolean isPageContainSectionList(List<String> sectionsTitles) {
        return sectionsTitles.containsAll(SECTIONS_LIST);
    }

    @AfterClass
    public static void closeAllWindows() {
        catalogpage.closeBrowser();
    }
}
