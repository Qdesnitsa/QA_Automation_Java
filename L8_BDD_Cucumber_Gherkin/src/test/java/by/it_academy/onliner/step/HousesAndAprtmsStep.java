package by.it_academy.onliner.step;

import by.it_academy.onliner.page.HomePage;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

public class HousesAndAprtmsStep {
    private static final String PATTERN_PRICE = "(До|От)\\s+\\d+[.,]?[0-9]+\\s+";
    private static final String HOUSES_AND_APRTMS_XPATH =
            "//*[contains(@class, 'b-main-navigation__dropdown-column b-main-navigation__dropdown-column_50')]" +
                    "//span[contains(@class, 'b-main-navigation__dropdown-advert-sign')]";
    private final HomePage homePage = new HomePage();

    @Then("housesAndApartments submenu {string} appears")
    public void submenuIsDisplayed(String title) {
        assertThat(homePage.isSubmenuDisplayed(HOUSES_AND_APRTMS_XPATH))
                .as("Submenu is not displayed " + title)
                .isTrue();
    }

    @Then("housesAndApartments submenu {string} contains cities")
    public void submenuContainsCities(String title, List<String> cities) {
        assertThat(homePage.getTexts(HOUSES_AND_APRTMS_XPATH))
                .as("Submenu " + title + " doesn't contain cities " + cities)
                .containsAll(cities);
    }

    @Then("housesAndApartments submenu {string} contains apartments")
    public void submenuContainsApartments(String title, List<String> apartments) {
        assertThat(homePage.getTexts(HOUSES_AND_APRTMS_XPATH))
                .as("Submenu " + title + " doesn't contain apartments " + apartments)
                .containsAll(apartments);
    }

    @Then("submenu autobarakholka {string} contains От, до {int}")
    public void submenuContainsPrices(String title, int price) {
        Pattern pattern = Pattern.compile(PATTERN_PRICE);
        assertThat(homePage.getTexts(HOUSES_AND_APRTMS_XPATH))
                .as("Submenu " + title + " doesn't contain prices " + price)
                .anyMatch(pattern.asPredicate());
    }
}
