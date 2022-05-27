package by.it_academy.task_01_calculator.main;

import by.it_academy.task_01_calculator.entity.Calculator;
import by.it_academy.task_01_calculator.output.OutputConsole;

public class CalculatorMain {

  public static void main(String[] args) {
    Calculator dataFromConsole = new Calculator();
    dataFromConsole.getResult();
    OutputConsole.printResultingMsg(dataFromConsole.toString());

    Calculator dataFromArgument = new Calculator("1.1+19.1-((3-2)+15)/2");
    dataFromArgument.getResult();
    OutputConsole.printResultingMsg(dataFromArgument.toString());

  }
}
