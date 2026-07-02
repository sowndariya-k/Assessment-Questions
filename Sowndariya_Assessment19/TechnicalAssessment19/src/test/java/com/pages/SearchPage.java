package com.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//div[@class='productinfo text-center']/p)[1]")
    WebElement firstProduct;

    @FindBy(xpath="(//a[contains(text(),'View Product')])[1]")
    WebElement viewProduct;

    public String getProductName() {
        return firstProduct.getText();
    }

    public void openProduct() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(viewProduct));
        viewProduct.click();
    }
}