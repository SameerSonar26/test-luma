package com.luma.base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	//@CucumberOptions(features = "src/test/resources/Features", glue = "com.luma.stepdefinition", dryRun = false)
	@CucumberOptions(features = "src/test/resources/Features",glue = "com.luma.stepdefinition",dryRun = false)
	public class TestRunner extends AbstractTestNGCucumberTests {
}
