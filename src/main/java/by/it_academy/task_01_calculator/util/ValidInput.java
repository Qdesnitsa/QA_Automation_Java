package by.it_academy.task_01_calculator.util;

import static by.it_academy.task_01_calculator.util.PatternRegex.*;

import by.it_academy.task_01_calculator.input.InputScanner;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidInput {
  private static final String INVALID_INPUT = "[[0-9]*[.,]?[0-9]+\\/\\*\\+\\-\\(\\)]+";
  private static String input;

  private ValidInput() {
  }

  /**
   * Метод проверяет строку на соответствие целым числам и символам '(',')','+','-','*','/'.
   * @return строку соответствующую условию.
   */
  public static String obtainValidElements() {
    input = InputScanner.obtainInput();

    for( ;!input.matches(INVALID_INPUT); input = InputScanner.obtainInput()) {
    }

    return input;
  }

  /**
   * Метод проверяет строку на соответствие целым числам и символам '(',')','+','-','*','/'.
   * @param input строка для проверки.
   * @return строку соответствующую условию
   * иначе выбрасывает исключение "Argument contains characters other than numbers and '(',')','+','-','*','/'.").
   */
  public static String obtainValidElements(String input) {

    if (!input.matches(INVALID_INPUT)) {
      throw new RuntimeException("Argument contains characters other than numbers and '(',')','+','-','*','/'.");
    }
    return input;
  }

  /**
   * Метод проверяет строку на соответствие последовательности цифр и символов для расчёта выражения.
   * @return строку, если она соответствует условию.
   */
  public static String obtainValidOrder() {
    input = obtainValidElements();
    List<Pattern> patterns = obtainArrayListPattern();
    Matcher matcher;
    int i;
    for (i = 0; i < patterns.size(); i++) {
      matcher = patterns.get(i).matcher(input);
      while (matcher.find()) {
        input = obtainValidElements();
        matcher = patterns.get(i).matcher(input);
        i = (i == patterns.size() - 1) ? i = 0 : i;
      }
    }
    return input;
  }

  /**
   * Метод проверяет строку на соответствие последовательности цифр и символов для расчёта выражения.
   * @param input строка для проверки.
   * @return строку, если она соответствует условию иначе выбрасывает исключение "Invalid consistency of characters."
   */
  public static String obtainValidOrder(String input) {
    input = obtainValidElements(input);
    List<Pattern> patterns = obtainArrayListPattern();
    Matcher matcher;
    int i;
    for (i = 0; i < patterns.size(); i++) {
      matcher = patterns.get(i).matcher(input);
      if (matcher.find()) {
        throw new RuntimeException("Invalid consistency of characters.");
      }
    }
    return input;
  }

  /**
   * Метод считает количество передаваемого элемента в строке.
   * @param targetElement целевой элемент для подсчета
   * @param input строка, в которой необходимо провести подсчет.
   * @return количество повторений
   */
  public static int countBrackets(char targetElement, String input) {
    int count = 0;

    for(int i = 0; i < input.toCharArray().length; i++) {
      if (input.charAt(i) == targetElement) {
        ++count;
      }
    }

    return count;
  }

  /**
   * Метод проверяет на равенство количество повторений символов '(' и ')'.
   * @return строку, если она соответствует условию.
   */
  public static String equalCountBrackets() {
    input = obtainValidOrder();
    int count1 = countBrackets('(', input);
    int count2 = countBrackets(')', input);
    while (count1 != count2) {
      input = obtainValidOrder();
      count1 = countBrackets('(', input);
      count2 = countBrackets(')', input);
    }

    return input;
  }

  /**
   * Метод проверяет на равенство количество повторений символов '(' и ')'.
   * @param input строка для проверки.
   * @return строку, если она соответствует условию иначе выбрасывает исключение "Unequal number of '(' and ')'."
   */
  public static String equalCountBrackets(String input) {
    input = obtainValidOrder(input);
    int count1 = countBrackets('(', input);
    int count2 = countBrackets(')', input);
    if (count1 != count2) {
      throw new RuntimeException("Unequal number of '(' and ')'.");
    }
    return input;
  }
}

