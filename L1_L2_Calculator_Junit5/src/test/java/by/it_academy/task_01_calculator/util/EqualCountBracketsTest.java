package by.it_academy.task_01_calculator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@Tag("utils")
public class EqualCountBracketsTest {
    @ParameterizedTest
    @CsvSource(value = {"((6+9-8)*9-9),((6+9-8)*9-9)", "(((6+9)-8)*9-9),(((6+9)-8)*9-9)", "(9+0)*9,(9+0)*9"})
    public void testEqualNumberOfBracketsInExpressionReturnExpression(String expression,String result) {
        //assertEquals("Incorrect expression: " + expression,result,ValidInput.equalCountBrackets(expression));
        List<String> expect = Arrays.stream(expression.split("")).collect(Collectors.toList());
        List<String> actual = Arrays.stream(ValidInput.equalCountBrackets(expression).split(""))
                .collect(Collectors.toList());
        assertThat(expect).hasSameSizeAs(actual);
    }

    @DisplayName("Count unequal number of brackets, expected RuntimeException")
    @Test
    void testEqualNumberOfBracketsInExpressionThrowException() {
        assertThrows(RuntimeException.class, () -> {
            ValidInput.equalCountBrackets("(((6+6)*6");
        }, "Expected to throw Exception, but it didn't");
    }
}
