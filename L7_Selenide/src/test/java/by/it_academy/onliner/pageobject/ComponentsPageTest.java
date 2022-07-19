package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ComponentsPageTest {
    private static ComponentsPage componentsPage;

    @BeforeAll
    public static void navigateToOnlinerFindAccessoriesTabAndClick() {
        OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        componentsPage = new ComputersAndNetworksPage()
                .clickOnComputersAndNetworksTabLink("Комплектующие");
    }

    @Test
    @Tag("selenide")
    public void testAllElementsContainName() {
        assertThat(componentsPage.getProductsNames())
                .as("Not all products contain name")
                .allMatch(e -> !e.isEmpty());
    }

    @Test
    @Tag("selenide")
    public void testAllElementsContainQuantity() {
        assertThat(componentsPage.getProductsDescription())
                .as("Not all products contain quantity")
                .allMatch(e -> e.contains("товар"));
    }

    @Test
    @Tag("selenide")
    public void testAllElementsContainPrice() {
        assertThat(componentsPage.getProductsDescription())
                .as("Not all products contain price")
                .allMatch(e -> e.contains("р."));
    }
}
