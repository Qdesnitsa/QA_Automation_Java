package by.it_academy.task_01_calculator.output;

public final class OutputConsole {
  private static String inputInstructionForUser = "Enter expression using: integers,+,-,*,/,(,) without spaces. Quantity of '(' and ')' should be equal.";

  private OutputConsole() {
  }

  /**
   * Метод выводит на консоль сообщение пользователю с инструкцией для ввода данных.
   */
  public static void printInstructions() {
    System.out.println(inputInstructionForUser);
  }

  /**
   * Метод выводит результат вычислений.
   * @param result результат вычисления.
   */
  public static void printResultingMsg(String  result) {
    System.out.println(result);
  }
}
