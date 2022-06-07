package by.it_academy.task_01_calculator;

import by.it_academy.task_01_calculator.util.ParserOfUserStringInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReplaceCommaWithDot {
    private String line;
    private String expectedResult;
    ParserOfUserStringInput parserOfUserStringInput;

    public ReplaceCommaWithDot(String line, String expectedResult) {
        this.line = line;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        parserOfUserStringInput = new ParserOfUserStringInput();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"1,2345", "1.2345"}, {"-5,4321", "-5.4321"},
                {"0,12345", "0.12345"}, {"1.1", "1.1"}};
        return Arrays.asList(data);
    }

    @Test
    public void testReplaceCommaWithDot() {
        Assert.assertEquals("Formatting is incorrect for value " + line, expectedResult,
                parserOfUserStringInput.replaceCommaWithDot(line));
    }

}
