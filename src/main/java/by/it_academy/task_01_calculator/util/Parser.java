package by.it_academy.task_01_calculator.util;

import by.it_academy.task_01_calculator.entity.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Parser {
    private static String input;
    private final static String DELIMITER = "[0-9]*[.,]?[0-9]+|\\+|\\-|\\*|\\/|\\(|\\)";
    private final static Pattern PATTERN = Pattern.compile(DELIMITER);

    /**
     * Метод делит строку, переданную с консоли, на объекты String при наличии любого из разделителей (DELIMITER).
     *
     * @return коллекцию Arraylist со всеми элементами.
     */
    public List<String> parserSixElements(Calculator calc) {
        input = ValidInput.equalCountBrackets();
        calc.setExpression(input);
        Matcher matcher = PATTERN.matcher(input);
        List<String> array = new ArrayList();

        for (int i = 0; matcher.find(); ++i) {
            array.add(i, matcher.group());
        }

        return array;
    }

    /**
     * Метод делит строку на объекты String при наличии любого из разделителей (DELIMITER).
     *
     * @param input строка для обработки.
     * @return коллекцию Arraylist со всеми элементами.
     */
    public List<String> parserSixElements(String input) {
        input = ValidInput.equalCountBrackets(input);
        Matcher matcher = PATTERN.matcher(input);
        List<String> array = new ArrayList();

        for (int i = 0; matcher.find(); ++i) {
            array.add(i, matcher.group());
        }

        return array;
    }
}
