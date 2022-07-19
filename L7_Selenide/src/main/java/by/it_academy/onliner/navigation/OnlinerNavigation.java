package by.it_academy.onliner.navigation;

import by.it_academy.onliner.pageobject.HomePage;

import static by.it_academy.onliner.framework.factory.ConfigReader.getConfigURL;
import static com.codeborne.selenide.Selenide.open;

public class OnlinerNavigation {
    public static HomePage navigateToOnlinerHomePage() {
        HomePage homePage = new HomePage();
        try {
            open(getConfigURL("base.url"));
        } catch (NullPointerException e) {
            throw new RuntimeException("No URL found in properties file");
        }
        return homePage;
    }
}
