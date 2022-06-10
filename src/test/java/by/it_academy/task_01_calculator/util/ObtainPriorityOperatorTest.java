package by.it_academy.task_01_calculator.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@Tag("utils")
public class ObtainPriorityOperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"+,1", "-,1", "*,2", "/,2"})
    public void testCorrectPriorityFourOperators(String operator, Integer priority) {
        assertEquals("Wrong result for value: " + operator, priority,
                PriorityOfOperator.obtainPriorityInt(operator));
    }
}
