package by.it_academy.task_01_calculator;

import by.it_academy.task_01_calculator.calculation.ICalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SubstractionTest {
    private double firstNumber;
    private double secondNumber;
    private double expectedResult;

    public SubstractionTest(double firstNumber, double secondNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{3.3, 2.3, 1.0}, {-1.0, -4.3, 3.3}, {0.0, 10.1, -10.1}};
        return Arrays.asList(data);
    }

    @Test
    public void testAddition() {
        Assert.assertEquals("Substraction is incorerct for values: " + firstNumber + " + " + secondNumber,
                expectedResult, ICalculator.diff(firstNumber, secondNumber), 0.0);
    }
}
