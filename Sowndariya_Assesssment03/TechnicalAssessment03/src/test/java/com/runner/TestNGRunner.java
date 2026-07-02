package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
		             "json:target/cucumber-reports/cucumber.json",
		             "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    features = "src/test/resources/feature/AddressBook.feature",
	    glue = "com.stepDefinition",
	    monochrome = true)
	public class TestNGRunner extends AbstractTestNGCucumberTests {

	}