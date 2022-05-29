package by.it_academy.task_01_calculator.calculation;

import by.it_academy.task_01_calculator.entity.Calculator;
import by.it_academy.task_01_calculator.util.Parser;
import by.it_academy.task_01_calculator.util.Priority;
import java.util.List;
import java.util.Stack;

public class CalculatorSuper implements ICalculator {
  private final Stack<Double> numbers = new Stack();
  private final Stack<String> operators = new Stack();
  private String input;
  private Parser parser = new Parser();

  public void calcResult(Calculator calc) {
    List<String> array;
    if (calc.getTypeOfInput() == 1) {
      input = calc.getExpression();
      array = parser.parserSixElements(input);
    } else
      array = parser.parserSixElements(calc);

    for(int i = 0; i < array.size(); ++i) {
      String element = array.get(i);

      try {
        double number = Double.parseDouble(element);
        numbers.push(number);
      } catch (NumberFormatException e) {
        if (element.equals("(")) {
          operators.push(element);
        } else if (element.equals(")")) {
          while (!operators.peek().equals("("))
            calculate();
            operators.pop();
          } else {
          if (operators.empty()) {
            operators.push(element);
          } else {
            Integer priority = Priority.obtainPriorityInt(element);
            while(!operators.empty() && !(operators.peek()).equals("(") && !(operators.peek()).equals(")") && priority <= Priority.obtainPriorityInt(operators.peek())) {
              calculate();
            }
            operators.push(element);
          }
        }
      }
    }
    while(!operators.empty()) {
      calculate();
    }
    calc.setResult(numbers.pop());
  }

  public void calculate() {
    String operator = operators.pop();
    Double b = numbers.pop();
    Double a = numbers.pop();
    Double result = null;
    switch(operator) {
      case "+":
        result = sum(a, b);
        break;
      case "-":
        result = diff(a, b);
        break;
      case "*":
        result = multiply(a, b);
        break;
      case "/":
        result = divide(a, b);
    }
    numbers.push(result);
  }

}
