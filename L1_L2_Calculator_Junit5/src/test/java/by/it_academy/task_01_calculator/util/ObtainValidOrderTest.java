package by.it_academy.task_01_calculator.util;

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
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@Tag("utils")
public class ObtainValidOrderTest {
    @DisplayName("Incorrect order of operations, expected RuntimeException")
    @Test
    void testIncorrectInputOrderOfElementsFromUserException() {
        assertThrows(RuntimeException.class, () -> {
            ValidInput.obtainValidOrder("4//*-4");
        });
    }

    @DisplayName("Incorrect usage of brackets, expected RuntimeException")
    @Test
    void testIncorrectInputOrderOfElementsFromUserException2() {
        assertThrows(RuntimeException.class, () -> {
            ValidInput.obtainValidOrder("(55-7*)");
        });
    }

    @DisplayName("Correct usage of numbers, operators, brackets")
    @ParameterizedTest
    @CsvSource(value = {"5+5-6,5+5-6", "5.99+9.06/9.000,5.99+9.06/9.000", "(888-0),(888-0)"})
    public void testDivisionPositiveNegativeValues(String inputString, String result)
            throws DivisionByZeroException {
        assertEquals("Wrong result for values: " + inputString, result,
                ValidInput.obtainValidOrder(inputString));
    }
}
