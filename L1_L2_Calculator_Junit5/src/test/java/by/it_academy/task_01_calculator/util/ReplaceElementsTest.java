package by.it_academy.task_01_calculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
@Tag("utils")
public class ReplaceElementsTest {
    private List<String> elements;
    private ParserOfUserStringInput parser;
    private List<String> list;

    @BeforeEach
    public void initParser() {
        parser = new ParserOfUserStringInput();
        list = new ArrayList<>();
        list.add("(");
        list.add("3,7");
        list.add("-3");
        list.add(")");
        list.add("/");
        list.add("-6,55");
    }

    @Test
    public void testHasReplacedNumbersWithSignBefore() {
        elements = parser.replaceNumbersWithSign(list);
        assertThat(elements)
                .hasSize(7)
                .containsExactlyElementsOf(Arrays.asList("(", "3,7", "+", "-3", ")", "/", "-6,55"));
    }

    @Test
    public void testIsCommasReplacedWithDots() {
        List<String> newArray = new ArrayList<>();
        newArray = list.stream().map(p->parser.replaceCommaWithDot(p)).collect(Collectors.toList());
        assertThat(newArray).as("Commas were not replaced with dots")
                .isEqualTo(Arrays.asList("(", "3.7", "-3", ")", "/", "-6.55"));
    }
}
