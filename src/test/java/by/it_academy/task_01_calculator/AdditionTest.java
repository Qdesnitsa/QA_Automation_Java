package by.it_academy.task_01_calculator;

import by.it_academy.task_01_calculator.calculation.ICalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AdditionTest {
    private double firstNumber;
    private double secondNumber;
    private double expectedResult;

    public AdditionTest(double firstNumber, double secondNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{2.3, 3.3, 5.6}, {-1.0, 4.0, 3.0}, {0.0, 10.1, 10.1}};
        return Arrays.asList(data);
    }

    @Test
    public void testAddition() {
        Assert.assertEquals("Addition is incorerct for values: " + firstNumber + " + " + secondNumber,
                expectedResult, ICalculator.sum(firstNumber, secondNumber), 0.0);
    }
}
