package by.it_academy.task_01_calculator.util;

import by.it_academy.task_01_calculator.entity.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParserOfUserStringInput {
    private static String input;
    /**
     * Проверка на наличие в строке положительных или отрицательных, целых или дробных чисел,
     * а также любого из операторов + - * / или скобок ( )
     */
    private final static String DELIMITER = "[-+]?\\d+(\\.\\d+)?|\\+|\\-|\\*|\\/|\\(|\\)";
    private final static Pattern PATTERN = Pattern.compile(DELIMITER);
    /**
     * Проверка на наличие в строке положительных или отрицательных дробных чисел
     */
    private final static Pattern PATTERN_1 = Pattern.compile("[-+]{1}\\d+(\\.\\d+)");
    /**
     * Проверка на наличие в строке положительных или отрицательных целых чисел
     */
    private final static Pattern PATTERN_2 = Pattern.compile("[-+]{1}\\d+");

    /**
     * Метод делит строку, переданную с консоли, на объекты String при наличии любого из разделителей (DELIMITER).
     *
     * @return коллекцию Arraylist со всеми элементами.
     */
    public List<String> parserSixElements(Calculator calc) {
        input = ValidInput.equalCountBrackets();
        String inputAfterReplacementComma = replaceCommaWithDot(input);
        calc.setExpression(input);
        Matcher matcher = PATTERN.matcher(inputAfterReplacementComma);
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
        String inputAfterReplacementComma = replaceCommaWithDot(input);
        Matcher matcher = PATTERN.matcher(inputAfterReplacementComma);
        List<String> array = new ArrayList();

        for (int i = 0; matcher.find(); ++i) {
            array.add(i, matcher.group());
        }

        replaceNumbersWithSign(array);
        return array;
    }

    public List<String> replaceNumbersWithSign(List<String> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (PATTERN_1.matcher(numbers.get(i)).matches() || PATTERN_2.matcher(numbers.get(i)).matches()) {
                String temp = numbers.get(i);
                numbers.set(i, "+");
                numbers.add(i + 1, temp.replace("+", ""));
                i++;
                if (i + 1 == numbers.size()) {
                    break;
                }
            }
        }
        return numbers;
    }

    public String replaceCommaWithDot(String inputBeforeReplacementComma) {
        String inputAterReplacementComma = "";
        if (inputBeforeReplacementComma.contains(",")) {
            inputAterReplacementComma = inputBeforeReplacementComma.replace(",", ".");
            return inputAterReplacementComma;
        } else {
            return inputBeforeReplacementComma;
        }
    }

}
