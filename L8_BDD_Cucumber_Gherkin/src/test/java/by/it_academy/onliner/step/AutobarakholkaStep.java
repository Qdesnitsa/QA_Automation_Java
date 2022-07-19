package by.it_academy.onliner.step;

import by.it_academy.onliner.page.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.AssertionsForInterfaceTypes;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutobarakholkaStep {
    private static final String PATTERN_MIN_PRICE_OF_PRODUCT = "(Авто до)\\s+\\d+[.,]?[0-9]+\\s+(р.)";
    private static final String AUTOBARAKHOLKA_SUBMENU_XPATH =
            "//*[contains(@class, 'b-main-navigation__dropdown-advert-link b-main-navigation__dropdown-advert-link_filter')]" +
                    "//span[contains(@class, 'b-main-navigation__dropdown-advert-sign')]";
    private final HomePage homePage = new HomePage();

    @Given("the user opens onliner.by website")
    public void theUserOpensOnlinerWebsite() {
        homePage.openOnlinerWebsite();
    }

    @When("the user hovers mouse on autobarakholka {string} section")
    public void theUserHoversOnTab(String tab) {
        homePage.hoverOnTab(tab);
    }

    @Then("submenu autobarakholka {string} appears")
    public void submenuIsDisplayed(String title) {
        assertThat(homePage.isSubmenuDisplayed(AUTOBARAKHOLKA_SUBMENU_XPATH))
                .as("Submenu is not displayed " + title)
                .isTrue();
    }

    @Then("submenu autobarakholka {string} contains sections: car models")
    public void submenuContainsTargetCarModels(String title, List<String> targetCarModels) {
        AssertionsForInterfaceTypes.assertThat(homePage.getTexts(AUTOBARAKHOLKA_SUBMENU_XPATH))
                .as("Submenu " + title + " doesn't contain car models " + targetCarModels)
                .containsAll(targetCarModels);
    }

    @Then("submenu autobarakholka {string} contains sections: Авто до {int} р.")
    public void submenuContainsMinPrice(String title, int targetMinPrice) {
        Pattern pattern = Pattern.compile(PATTERN_MIN_PRICE_OF_PRODUCT);
        AssertionsForInterfaceTypes.assertThat(homePage.getTexts(AUTOBARAKHOLKA_SUBMENU_XPATH))
                .as("Submenu " + title + " doesn't contain min price " + targetMinPrice)
                .anyMatch(pattern.asPredicate());
    }

    @Then("submenu autobarakholka {string} contains sections: cities")
    public void submenuContainsCities(String title, List<String> targetCities) {
        AssertionsForInterfaceTypes.assertThat(homePage.getTexts(AUTOBARAKHOLKA_SUBMENU_XPATH))
                .as("Submenu " + title + " doesn't contain following cities " + targetCities)
                .containsAll(targetCities);
    }
}
