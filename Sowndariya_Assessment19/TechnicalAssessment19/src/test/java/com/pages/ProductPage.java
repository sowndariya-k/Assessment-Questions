package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[contains(text(),'Add to wishlist')]")
    WebElement addWishlist;

    @FindBy(xpath="//u[contains(text(),'View Wishlist')]")
    WebElement viewWishlist;

    public void addToWishlist() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(addWishlist));

        addWishlist.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(viewWishlist));

        viewWishlist.click();
    }
}