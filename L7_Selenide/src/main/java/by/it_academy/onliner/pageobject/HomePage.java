package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.framework.BasePage;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {
    private static final String NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    private static final String SECTION_BUTTON_XPATH_PATTERN = "//*[contains(@class, 'project-navigation__sign')" +
            " and contains(text(), '%s')]";

    public CatalogPage clickOnNavigationHeaderLink(String linkContains) {
        $x(format(NAVIGATION_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new CatalogPage();
    }

    public void clickOnSectionButton(String linkContains) {
        $x(format(SECTION_BUTTON_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
    }
}
