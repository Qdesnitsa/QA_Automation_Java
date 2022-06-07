package by.it_academy.task_01_calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(org.junit.runners.Suite.class)
@Suite.SuiteClasses({
        AdditionTest.class,
        DivisionTest.class,
        MultiplicationTest.class,
        SubstractionTest.class,
        ReplaceCommaWithDot.class})
public class AllTests {
}

