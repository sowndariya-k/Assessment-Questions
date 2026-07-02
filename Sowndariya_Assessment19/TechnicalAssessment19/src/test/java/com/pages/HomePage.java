package com.pages;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsMenu;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchBtn;
    

    public void searchProduct(String product) {
    	productsMenu.click(); 
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(searchBox));

        searchBox.sendKeys(product);
        searchBtn.click();
    }
}