package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.framework.BasePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private final ElementsCollection catalogLinks =
            $$x("//*[@class = 'catalog-navigation-classifier__item ']");
    private static final String CATALOG_SECTION_LINK_XPATH_PATTERN =
            "//*[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";

    public List<String> getCatalogLinks() {
        return catalogLinks.shouldHave(sizeGreaterThan(0)).texts();
    }

    public void clickOnCatalogSectionLink(String linkContains) {
        $x(format(CATALOG_SECTION_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
    }
}
