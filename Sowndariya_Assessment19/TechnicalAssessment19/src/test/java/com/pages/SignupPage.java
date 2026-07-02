package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="id_gender1")
    WebElement title;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="last_name")
    WebElement lastName;

    @FindBy(id="address1")
    WebElement address;

    @FindBy(id="state")
    WebElement state;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="zipcode")
    WebElement zip;

    @FindBy(id="mobile_number")
    WebElement mobile;

    @FindBy(xpath="//button[@data-qa='create-account']")
    WebElement createBtn;

    @FindBy(xpath="//h2[@data-qa='account-created']")
    WebElement successMsg;

    @FindBy(xpath="//a[@data-qa='continue-button']")
    WebElement continueBtn;

    public void fillForm(String pass) {
        title.click();
        password.sendKeys(pass);
        firstName.sendKeys("Test");
        lastName.sendKeys("User");
        address.sendKeys("Chennai");
        state.sendKeys("TN");
        city.sendKeys("Chennai");
        zip.sendKeys("600001");
        mobile.sendKeys("9999999999");
        createBtn.click();
    }

    public boolean isAccountCreated() {
        return successMsg.isDisplayed();
    }

    public void clickContinue() {
        continueBtn.click();
    }
}