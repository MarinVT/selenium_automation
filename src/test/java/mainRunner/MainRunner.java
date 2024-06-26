package mainRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"classpath:features"},
        tags = "intimno",
        glue = {"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json" ,
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class MainRunner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

}

