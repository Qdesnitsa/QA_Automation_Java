package by.it_academy.onliner.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "junit:target/junit_cucumber.xml",
                "html:target/cucumber-htmlreports/CucumberTestRunner"},
        monochrome = true,
        tags = "@smoke",
        glue = "by.it_academy.onliner",
        features = "classpath:features/"
)
public class CucumberTestRunner {
}
