package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookPage {
    WebDriver driver;

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddressBook() {
        driver.findElement(By.linkText("Address Book")).click();
    }

    public void clickNewAddress() {
        driver.findElement(By.linkText("New Address")).click();
    }

    public void enterFirstName(String firstname) {

        driver.findElement(By.id("input-firstname"))
              .sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
    }

    public void enterAddress(String address) {
        driver.findElement(By.id("input-address-1")).sendKeys(address);
    }

    public void enterCity(String city) {
        driver.findElement(By.id("input-city")).sendKeys(city);
    }

    public void enterPostCode(String postcode) {
        driver.findElement(By.id("input-postcode")).sendKeys(postcode);
    }

    public void enterCountry(String country) {
        driver.findElement(By.id("input-country")).sendKeys(country);
    }

    public void enterRegion(String region) {
        driver.findElement(By.id("input-zone")).sendKeys(region);
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.xpath("//*[@id='account-address']/div[1]")).getText();
    }
}