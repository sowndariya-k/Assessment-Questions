package com.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchStepDefinition {

    WebDriver driver;

    @Given("User is on TutorialsNinja home page")
    public void user_is_on_tutorials_ninja_home_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");
    }

    @When("User enter Keyword search as {string}")
    public void user_enter_keyword_search_as(String keyword) {

        driver.findElement(By.name("search")).sendKeys(keyword);
    }

    @When("User click on search button")
    public void user_click_on_search_button() {
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    }

    @Then("User should see search result status as {string}")
    public void user_should_see_search_result_status_as(String resultStatus) {

        boolean productFound =
                driver.getPageSource().contains("There is no product");

        if(resultStatus.equalsIgnoreCase("contain")) {
            Assert.assertFalse(productFound);
        } else {
            Assert.assertTrue(productFound);
        }

        driver.quit();
    }
}