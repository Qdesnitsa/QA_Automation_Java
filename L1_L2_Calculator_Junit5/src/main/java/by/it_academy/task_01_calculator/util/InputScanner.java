package by.it_academy.task_01_calculator.util;

import by.it_academy.task_01_calculator.output.OutputConsole;

import java.util.Scanner;

public final class InputScanner {
    private static String input;

    private InputScanner() {
    }

    /**
     * Метод принимает от пользователя с консоли строку с любыми символами.
     *
     * @return строку без изменений.
     */
    public static String obtainStringInput() {
        @SuppressWarnings("unchecked")
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

}
