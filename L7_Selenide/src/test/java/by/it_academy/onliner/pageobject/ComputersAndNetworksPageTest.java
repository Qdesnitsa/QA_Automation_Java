package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ComputersAndNetworksPageTest {
    private static final List<String> COMPUTERS_AND_NETWORKS_TABS_LIST = Arrays.asList("Ноутбуки, компьютеры, мониторы",
            "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static ComputersAndNetworksPage computersAndNetworksPage;

    @BeforeAll
    public static void navigateToOnlinerFindComputersAndNetworksTabAndClick() {
        OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        computersAndNetworksPage = new ComputersAndNetworksPage()
                .clickOnTheFirstTabOfSection();
    }

    @Test
    @Tag("selenide")
    public void testSectionContainsTabsList() {
        assertThat(computersAndNetworksPage.getComputersAndNetworksLinks())
                .as("Page sections don't contain section list")
                .containsAll(COMPUTERS_AND_NETWORKS_TABS_LIST);
    }
}
