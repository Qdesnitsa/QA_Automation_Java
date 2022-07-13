package by.it_academy.onliner.page;

import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComponentsPage extends BasePage {

    public List<String> findProductNames() {
        List<String> webElementsWithNames = findElements(By.xpath(PathName.COMPONENTS_NAME_LOCATOR))
                .stream()
                .flatMap(s -> Stream.ofNullable(s))
                .map(p -> p.getText())
                .filter(el -> !el.isEmpty())
                .collect(Collectors.toList());
        return webElementsWithNames;
    }

    public List<String> findProductDescriptions() {
        List<String> webElementsWithDescriptions = findElements(By.xpath(PathName.COMPONENTS_DESCRIPTION_LOCATOR))
                .stream()
                .flatMap(s -> Stream.ofNullable(s))
                .map(p -> p.getText())
                .filter(el -> !el.isEmpty())
                .collect(Collectors.toList());
        return webElementsWithDescriptions;
    }

}
