package by.it_academy.task_01_calculator.calculation;

import by.it_academy.task_01_calculator.exception.DivisionByZeroException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;


@Execution(ExecutionMode.CONCURRENT)
@Tag("calculator")
public class DivisionTest {

    @DisplayName("Division by zero, expected DivisionByZeroException")
    @Test
    public void testDivisionByZeroExpectedDivisionByZeroException() {
        Assertions.assertThrows(DivisionByZeroException.class, () -> {
            ICalculator.divide(10.0, 0.0);
        });
    }

    @Test
    public void testDivisionByZeroExpectedDivisionByZeroExceptionMessage() {
        DivisionByZeroException thrown = Assertions.assertThrows(DivisionByZeroException.class, () -> {
            ICalculator.divide(10.0, 0.0);
        }, "DivisionByZeroException was expected");
        Assertions.assertEquals(" Division by zero is prohibited.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"6.0,3.0,2.0", "-8.0,-4.0,2.0", "0.0,3.0,0.0"})
    public void testDivisionPositiveNegativeValues(double firstNumber, double secondNumber, double result)
            throws DivisionByZeroException {
        assertEquals("Wrong result for values: " + firstNumber + "/" + secondNumber, result,
                ICalculator.divide(firstNumber, secondNumber), 0.0);
    }
}
