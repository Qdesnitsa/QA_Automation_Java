package by.it_academy.onliner.page;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {
    public static final String ONLINER_URL = "https://onliner.by/";
    private static final String HEADER_TAB_XPATH_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    public void openOnlinerWebsite() {
        open(ONLINER_URL);
    }

    public void hoverOnTab(String linkContains) {
        actions().moveToElement($x(String.format(HEADER_TAB_XPATH_PATTERN, linkContains))
                .shouldBe(visible, ofSeconds(20))).perform();
    }

    public boolean isSubmenuDisplayed(String xpath) {
        return $x(xpath)
                .shouldBe(visible, ofSeconds(20))
                .isDisplayed();
    }

    public List<String> getTexts(String xpath) {
        return $$x(xpath).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }
}
