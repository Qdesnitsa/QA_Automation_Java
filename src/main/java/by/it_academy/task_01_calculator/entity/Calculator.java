package by.it_academy.task_01_calculator.entity;

import by.it_academy.task_01_calculator.calculation.CalculatorSuper;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

public class Calculator implements Serializable {
    private static final long serialVersionUID = -7456176617850911171L;
    private String expression;
    private double result;
    private int typeOfInput;
    private final CalculatorSuper CALC_SUPER = new CalculatorSuper();

    public Calculator() {
        this.typeOfInput = 0;
    }

    public Calculator(String expression) {
        this.expression = expression;
        this.typeOfInput = 1;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        CALC_SUPER.calcResult(this);
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getTypeOfInput() {
        return typeOfInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Calculator that = (Calculator) o;
        return Double.compare(that.result, result) == 0 && typeOfInput == that.typeOfInput
                && Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result, typeOfInput);
    }

    @Override
    public String toString() {
        DecimalFormat dF = new DecimalFormat("#.##");
        return expression +
                " = " + dF.format(result);
    }
}
