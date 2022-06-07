package by.it_academy.task_01_calculator.calculation;

import by.it_academy.task_01_calculator.entity.Calculator;
import by.it_academy.task_01_calculator.exception.DivisionByZeroException;
import by.it_academy.task_01_calculator.output.OutputConsole;
import by.it_academy.task_01_calculator.util.ParserOfUserStringInput;
import by.it_academy.task_01_calculator.util.PriorityOfOperator;

import java.util.List;
import java.util.Stack;

public class CalculatorSuper implements ICalculator {
    private final Stack<Double> numbers = new Stack();
    private final Stack<String> operators = new Stack();
    private String input;
    private ParserOfUserStringInput parser = new ParserOfUserStringInput();

    public void calculateResult(Calculator calc) {
        List<String> array;
        if (calc.getTypeOfInput() == 1) {
            input = calc.getExpression();
            array = parser.parserSixElements(input);
        } else
            array = parser.parserSixElements(calc);

        for (int i = 0; i < array.size(); ++i) {
            String element = array.get(i);

            try {
                double number = Double.parseDouble(element);
                numbers.push(number);
            } catch (NumberFormatException e) {
                if (element.equals("(")) {
                    operators.push(element);
                } else if (element.equals(")")) {
                    while (!operators.peek().equals("("))
                        calculateOneOfFourOperation();
                    operators.pop();
                } else {
                    if (operators.empty()) {
                        operators.push(element);
                    } else {
                        Integer priority = PriorityOfOperator.obtainPriorityInt(element);
                        while (!operators.empty() &&
                                !(operators.peek()).equals("(") &&
                                !(operators.peek()).equals(")") &&
                                priority <= PriorityOfOperator.obtainPriorityInt(operators.peek())) {
                            calculateOneOfFourOperation();
                        }
                        operators.push(element);
                    }
                }
            }
        }
        while (!operators.empty()) {
            calculateOneOfFourOperation();
        }
        calc.setResult(numbers.pop());
    }

    public void calculateOneOfFourOperation() {
        String operator = operators.pop();
        Double b = numbers.pop();
        Double a = numbers.pop();
        Double result = null;
        switch (operator) {
            case "+":
                result = ICalculator.sum(a, b);
                break;
            case "-":
                result = ICalculator.diff(a, b);
                break;
            case "*":
                result = ICalculator.multiply(a, b);
                break;
            case "/":
                try {
                    result = ICalculator.divide(a, b);
                } catch (DivisionByZeroException e) {
                    OutputConsole.printResultingMsg(String.valueOf(e));
                }
        }
        numbers.push(result);
    }
}

