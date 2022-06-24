package by.it_academy.task_01_calculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

@Execution(ExecutionMode.CONCURRENT)
@Tag("utils")
public class ReplaceCommaWithDotTest {
    ParserOfUserStringInput parserOfUserStringInput;
    @BeforeEach
    public void setUp() {
        parserOfUserStringInput = new ParserOfUserStringInput();
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2345', 1.2345", "'-5,4321', -5.4321", "'0,0',0.0"})
    public void testReplaceCommaWithDot(String line, String expectedResult) {
        assertEquals("Formatting is incorrect for value " + line, expectedResult,
                parserOfUserStringInput.replaceCommaWithDot(line));
    }

}
