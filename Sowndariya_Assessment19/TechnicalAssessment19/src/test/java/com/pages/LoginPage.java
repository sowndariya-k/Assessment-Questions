package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[contains(text(),'Signup / Login')]")
    WebElement signupLogin;

    @FindBy(xpath="//input[@data-qa='signup-name']")
    WebElement name;

    @FindBy(xpath="//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath="//button[@data-qa='signup-button']")
    WebElement signupBtn;

    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath="//input[@data-qa='login-password']")
    WebElement loginPassword;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement loginBtn;

    public void openSignup() {
        signupLogin.click();
    }

    public void signup(String n, String e) {
        name.sendKeys(n);
        email.sendKeys(e);
        signupBtn.click();
    }

    public void login(String e, String p) {
        loginEmail.sendKeys(e);
        loginPassword.sendKeys(p);
        loginBtn.click();
    }
}