package by.it_academy.task_01_calculator.calculation;

public interface ICalculator {
  default double sum(double a, double b) {
    return a + b;
  }
  default double diff(double a, double b) {
    return a - b;
  }
  default double multiplying(double a, double b) {
    return a * b;
  }
  default double division(double a, double b) {
    if (b == 0.0D) {
      throw new RuntimeException("Do not divide by zero");
    } else {
      return a / b;
    }
  }
}