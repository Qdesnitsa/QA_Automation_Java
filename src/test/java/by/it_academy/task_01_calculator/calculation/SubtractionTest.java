package by.it_academy.task_01_calculator.calculation;

import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("calculator")
public class SubtractionTest {

    @ParameterizedTest
    @CsvSource(value = {"3.3, 2.3, 1.0", "-1.0, -4.3, 3.3", "0.0, 10.1, -10.1"})
    public void testSubtraction(double firstNumber, double secondNumber, double expectedResult) {
        Assert.assertEquals("Subtraction is incorrect for values: " + firstNumber + " + " + secondNumber,
                expectedResult, ICalculator.diff(firstNumber, secondNumber), 0.0);
    }
}
