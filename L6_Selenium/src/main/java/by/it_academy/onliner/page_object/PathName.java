package by.it_academy.onliner.page_object;

public class PathName {
    public static final String ONLINER_LINK = "https://www.onliner.by/";
    public static final String CATALOG = "//*[@class='b-main-navigation__text' and contains(text(), '%s')]";
    public static final String CATALOG_TOP_MENU = "//*[@class = 'catalog-navigation-classifier__item ']";
    public static final String COMPUTERS_AND_SMTH
            = "//*[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";
    public static final String COMPUTERS_AND_NETWORKS_LIST_LEFT
            = "//*[@class = 'catalog-navigation-list__aside catalog-navigation-list__aside_active']" +
            "/div[@class = 'catalog-navigation-list__aside-list']" +
            "/div[contains(@class, 'catalog-navigation-list__aside-item')]" +
            "/div[contains(@class, 'catalog-navigation-list__aside-title')]";
    public static final String NOTEBOOKS_COMPUTERS_MONITORS
            = "//*[contains(@class, 'catalog-navigation-list__aside-title') " +
            "and contains(text(), ' Ноутбуки, компьютеры, мониторы')]";
    public static final String COMPONENTS_DESCRIPTION_LOCATOR
            = "//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
            "and not (contains(text(), 'Комплектующие для'))]" +
            "//following-sibling::div//span//*[@class='catalog-navigation-list__dropdown-description']";
    public static final String COMPONENTS_NAME_LOCATOR
            = "//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
            "and not (contains(text(), 'Комплектующие для'))]" +
            "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
            "//span//*[contains(@class, 'catalog-navigation-list__dropdown-title')]";
    public static final String COMPONENTS
            = "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s') " +
            "and not (contains(text(), 'Комплектующие для'))]";

}
