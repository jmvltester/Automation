package cucumber.Options;


import java.io.*;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/features"} ,
		glue = {"Stepdefinatios"},
		monochrome=true
		//plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)


public class TestRunner {
@AfterClass
public static void writeExtentReport() {
	Reporter.loadXMLConfig(new File("src/test/java/extent-config.xml"));
    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
    Reporter.setSystemInfo("Selenium", "3.7.0");
    Reporter.setSystemInfo("Maven", "3.5.2");
    Reporter.setSystemInfo("Java Version", "1.8.0_151");
}
}
