package by.it_academy.task_01_calculator.util;

import by.it_academy.task_01_calculator.entity.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Parser {
    private static String input;
    private final static String DELIMITER = "[-+]?\\d+(\\.\\d+)?|\\+|\\-|\\*|\\/|\\(|\\)";
    private final static Pattern PATTERN = Pattern.compile(DELIMITER);
    private final static Pattern PATTERN_1 = Pattern.compile("[-+]{1}\\d+(\\.\\d+)");
    private final static Pattern PATTERN_2 = Pattern.compile("[-+]{1}\\d+");

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

        replaceNumbersWithSign(array);
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

        replaceNumbersWithSign(array);
        return array;
    }

    public List<String> replaceNumbersWithSign(List<String> array) {
        for (int i = 1; i < array.size(); i++) {
            if (PATTERN_1.matcher(array.get(i)).matches() || PATTERN_2.matcher(array.get(i)).matches()) {
                String temp = array.get(i);
                array.set(i, "+");
                array.add(i + 1, temp.replace("+", ""));
                i++;
                if (i + 1 == array.size()) {
                    break;
                }
            }
        }
        return array;
    }

}
