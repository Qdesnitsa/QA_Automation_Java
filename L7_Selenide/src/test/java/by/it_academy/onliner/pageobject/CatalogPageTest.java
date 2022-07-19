package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CatalogPageTest {
    private static final List<String> SECTIONS_LIST = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника",
            "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");
    private static CatalogPage catalogpage;

    @BeforeAll
    public static void navigateToOnlinerClickOnCatalogLink() {
        catalogpage = OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог");
    }

    @Test
    @Tag("selenide")
    public void testPageSectionsContainSectionList() {
        assertThat(catalogpage.getCatalogLinks())
                .as("Page sections don't contain section list")
                .containsAll(SECTIONS_LIST);
    }
}
