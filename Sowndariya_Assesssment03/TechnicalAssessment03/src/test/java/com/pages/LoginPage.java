package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccount() {
        driver.findElement(By.linkText("My Account")).click();
    }

    public void clickLogin() {
        driver.findElement(By.linkText("Login")).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
}