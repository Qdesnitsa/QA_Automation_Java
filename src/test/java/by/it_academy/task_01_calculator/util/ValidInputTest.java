package by.it_academy.task_01_calculator.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@Tag("utils")
public class ValidInputTest {

    @ParameterizedTest
    @CsvSource(value = {"6+9-(6+99/9)/0,6+9-(6+99/9)/0","123456,123456", "0.0,0.0"})
    public void testUserEnteredNumbersOrFourOperators(String inputFromUser, String result) {
        assertEquals("Wrong result for values: " + inputFromUser, result,
                ValidInput.obtainValidElements(inputFromUser));
    }

    @Test
    public void testIncorrectInputFromUser() {
        assertEquals("Argument contains characters other than numbers and '(',')','+','-','*','/'.",
                ValidInput.obtainValidElements("inputFromUser"));
    }
}

