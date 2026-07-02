package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//td[@class='cart_description']/h4/a")
    WebElement productName;

    @FindBy(xpath="//td[@class='cart_price']/p")
    WebElement price;

    @FindBy(xpath="//a[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @FindBy(xpath="//u[contains(text(),'View Cart')]")
    WebElement viewCart;

    public String getWishlistProduct() {
        return productName.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void moveToCart() {
        addToCart.click();
        viewCart.click();
    }
}