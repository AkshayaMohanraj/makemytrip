package com.makemytrip.runner;

import org.bouncycastle.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.makemytrip.baseclass.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/com/makemytrip/feature/BookAFlight.feature", 
				  glue = "com\\makemytrip\\stepdefinition", 
				  monochrome = true, 
				  strict = true, 
				  dryRun = false
)

public class RunWithChrome extends BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Throwable {
		prop=readPropertyFile();
		String browser = prop.getProperty("browserName");
		driver = BaseClass.getBrowser(browser);
		setExtentReport();
	}
	@After
	private void testresult() {
		// TODO Auto-generated method stub

	}

	@AfterClass
	public static void report() {
		extent.flush();
		driver.quit();
	}
}
