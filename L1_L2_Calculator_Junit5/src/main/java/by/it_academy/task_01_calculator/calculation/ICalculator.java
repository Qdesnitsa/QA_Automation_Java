package by.it_academy.task_01_calculator.calculation;

import by.it_academy.task_01_calculator.exception.DivisionByZeroException;

public interface ICalculator {
    static double sum(double a, double b) {
        return a + b;
    }

    static double diff(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) throws DivisionByZeroException {
        if (b == 0.0D) {
            throw new DivisionByZeroException(" Division by zero is prohibited.");
        } else {
            return a / b;
        }
    }
}