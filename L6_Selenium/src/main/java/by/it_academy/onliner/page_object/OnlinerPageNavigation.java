package by.it_academy.onliner.page_object;

public class OnlinerPageNavigation extends BasePage {

    public static OnlinerPage navigateToFirstPage() {
        OnlinerPage onlinerPage = new OnlinerPage();
        onlinerPage.navigate(PathName.ONLINER_LINK);
        return onlinerPage;
    }
}
