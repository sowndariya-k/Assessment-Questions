package com.stepDefinition;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AddressBookStepDefinition {

    WebDriver driver;

    @Given("User login to TutorialsNinja application")
    public void user_login_to_tutorials_ninja_application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("sowndariya@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Sow@911!");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.linkText("Address Book")).click();
        driver.findElement(By.linkText("New Address")).click();
    }

    @When("User enters address details")
    public void user_enters_address_details(DataTable dataTable) {

        Map<String, String> data =
                dataTable.asMap(String.class, String.class);

        driver.findElement(By.id("input-firstname")).sendKeys(data.get("firstname"));

        driver.findElement(By.id("input-lastname")).sendKeys(data.get("lastname"));

        driver.findElement(By.id("input-address-1")).sendKeys(data.get("address1"));

        driver.findElement(By.id("input-city")).sendKeys(data.get("city"));

        driver.findElement(By.id("input-postcode")).sendKeys(data.get("postcode"));

        Select country =new Select(driver.findElement(By.id("input-country")));
        country.selectByVisibleText(data.get("country"));

        Select region =new Select(driver.findElement(By.id("input-zone")));
        region.selectByVisibleText(data.get("region"));
    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("Address should be added successfully")
    public void address_should_be_added_successfully() {
    	
        String message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertTrue(message.contains("Your address has been successfully added"));
    }
}