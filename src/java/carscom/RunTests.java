package carscom;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.Browser;
import framework.PropertiesReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/java/carscom/features",
        glue = { "carscom.steps"},
        format = {"json:target/Destination/cucumber.json"})

public class RunTests extends AbstractTestNGCucumberTests {

  @BeforeClass
    public static void startBrowser() {
    PropertiesReader properties = new PropertiesReader();
    Browser.getInstance().navigateURL(properties.readUrl());
  }

  @AfterClass
  public static void closeDriver() {
    Browser.getInstance().closeDriver();
  }
}
