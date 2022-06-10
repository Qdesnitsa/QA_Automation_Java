package by.it_academy.task_01_calculator;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Execution(ExecutionMode.CONCURRENT)
@SelectPackages({"by.it_academy.task_01_calculator.calculation",
                "by.it_academy.task_01_calculator.util"})
@Suite
@IncludeTags({"calculator","utils"})
public class AllTests {
}

