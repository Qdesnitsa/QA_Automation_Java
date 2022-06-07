package by.it_academy.task_01_calculator;

import by.it_academy.task_01_calculator.calculation.ICalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MultiplicationTest {
    private double firstNumber;
    private double secondNumber;
    private double expectedResult;

    public MultiplicationTest(double firstNumber, double secondNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{2.0, 3.0, 6.0}, {-4.1, -2.2, 9.02}, {0.0, 3.7, 0.0}};
        return Arrays.asList(data);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals("Multiplication is incorerct for values: " + firstNumber + " + " + secondNumber,
                expectedResult, ICalculator.multiply(firstNumber, secondNumber), 0.0);
    }
}
