package by.it_academy.task_01_calculator;

import by.it_academy.task_01_calculator.calculation.ICalculator;
import by.it_academy.task_01_calculator.exception.DivisionByZeroException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisionTest {

    @Test(expected = DivisionByZeroException.class)
    public void testDivisionByZero() throws DivisionByZeroException {
        assertEquals("Division by zero should throw exception",
                ICalculator.divide(4.8, 0.0), 10);
    }

    @Test
    public void testDivisionPositiveNumbers() throws DivisionByZeroException {
        assertEquals("Division should work correctly for: ", 2.0,
                ICalculator.divide(6.0, 3.0), 0.0);
    }

    @Test
    public void testDivisionNegativeNumbers() throws DivisionByZeroException {
        assertEquals("Division should work correctly for: ", -2.0,
                ICalculator.divide(-6.0, 3.0), 0.0);
    }

    @Test
    public void testDivisionNumenatorZero() throws DivisionByZeroException {
        assertEquals("Division should work correctly for: ", 0.0,
                ICalculator.divide(0.0, 3.0), 0.0);
    }
}
