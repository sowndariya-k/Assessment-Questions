package com.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.base.BaseTest;
import com.base.TestListener;
import com.pages.LoginPage;
import com.pages.SignupPage;
import com.Test.Utilities.DPExcel;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(priority = 1, dataProvider = "registerData", dataProviderClass = DPExcel.class)
    public void registerUser(String name, String email, String password) {

        LoginPage login = new LoginPage(getDriver());
        login.openSignup();
        login.signup(name, email);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

        SignupPage sign = new SignupPage(getDriver());
        sign.fillForm(password);

        Assert.assertTrue(sign.isAccountCreated());
    }

    @Test(priority = 2, dataProvider = "existingUserData", dataProviderClass = DPExcel.class)
    public void registerExistingUser(String name, String email, String password) {

        LoginPage login = new LoginPage(getDriver());
        login.openSignup();
        login.signup(name, email);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'Email Address already exist')]")));

        Assert.assertTrue(
                getDriver().findElement(By.xpath("//p[contains(text(),'Email Address already exist')]")).isDisplayed()
        );
    }

    @Test(priority = 3, dataProvider = "loginData", dataProviderClass = DPExcel.class)
    public void validLogin(String name, String email, String password) {

        LoginPage login = new LoginPage(getDriver());
        login.openSignup();
        login.login(email, password);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")));

        Assert.assertTrue(
                getDriver().findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()
        );
    }

    @Test(priority = 4, dataProvider = "invalidLoginData", dataProviderClass = DPExcel.class)
    public void invalidLogin(String name, String email, String password) {

        LoginPage login = new LoginPage(getDriver());
        login.openSignup();
        login.login(email, password);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")));

        Assert.assertTrue(
                getDriver().findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed()
        );
    }
}