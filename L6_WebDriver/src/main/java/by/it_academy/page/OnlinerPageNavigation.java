package by.it_academy.page;

public class OnlinerPageNavigation extends BasePage {

    public static OnlinerPage navigateToFirstPage() {
        OnlinerPage onlinerPage = new OnlinerPage();
        onlinerPage.navigate(PathNames.ONLINER_LINK);
        return onlinerPage;
    }
}
