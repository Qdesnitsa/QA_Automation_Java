package by.it_academy.task_01_calculator.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@Tag("utils")
public class CountBracketsTest {
    @ParameterizedTest
    @CsvSource(value = {"(,(9+99)*9,1", "*,(9+99)*9-8*8,2", "/,(9+99)*9-8*8,0"})
    public void testQuantityOfTargetElement(char targetElement, String input, int result) {
        assertEquals("Wrong result for value: " + input, result,
                ValidInput.countBrackets(targetElement, input));
    }
}

