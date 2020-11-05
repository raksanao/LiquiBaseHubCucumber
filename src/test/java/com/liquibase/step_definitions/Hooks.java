package com.liquibase.step_definitions;


import com.liquibase.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 2)
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        // how to check if scenario failed
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot =(TakesScreenshot) Driver.getDriver();
            byte[] image =takesScreenshot.getScreenshotAs(OutputType.BYTES);
            // attach screenshot to the report
            scenario.embed(image,"image/png",scenario.getName());
        }

        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
