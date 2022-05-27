package by.it_academy.task_01_calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class PatternRegex {
  private static final String INVALID_ORDER_OPERATORS = "[\\+|\\-|\\*|\\/]{2,}";
  private static final String INVALID_ORDER_WITH_BRACKETS = "[\\(][\\)|\\+|\\-|\\*|\\/]|[\\)][\\(]|[\\d]]|[0-9][\\(]|[\\(][\\d+][\\)]|[\\+|\\-|\\*|\\/][\\)]";
  private static final String INVALID_START_LINE = "^[\\+|\\-|\\*|\\/\\)]";
  private static final String INVALID_END_LINE = "[\\+|\\-|\\*|\\/\\(]$";
  private static final Pattern PATTERN_1;
  private static final Pattern PATTERN_2;
  private static final Pattern PATTERN_3;
  private static final Pattern PATTERN_4;

  static {
    PATTERN_1 = Pattern.compile(PatternRegex.INVALID_ORDER_OPERATORS);
    PATTERN_2 = Pattern.compile(INVALID_ORDER_WITH_BRACKETS);
    PATTERN_3 = Pattern.compile(INVALID_START_LINE);
    PATTERN_4 = Pattern.compile(INVALID_END_LINE);
  }

  public static List<Pattern> obtainArrayListPattern() {
    List<Pattern> patterns = new ArrayList();
    patterns.add(PATTERN_1);
    patterns.add(PATTERN_2);
    patterns.add(PATTERN_3);
    patterns.add(PATTERN_4);
    return patterns;
  }

}
