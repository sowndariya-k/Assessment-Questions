package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
    WebElement checkoutBtn;

    @FindBy(name="name_on_card")
    WebElement name;

    @FindBy(name="card_number")
    WebElement card;

    @FindBy(name="cvc")
    WebElement cvc;

    @FindBy(name="expiry_month")
    WebElement month;

    @FindBy(name="expiry_year")
    WebElement year;

    @FindBy(id="submit")
    WebElement payBtn;

    @FindBy(xpath="//h2[contains(text(),'Order Placed!')]")
    WebElement confirmMsg;

    public void checkout() {
        checkoutBtn.click();
    }

    public void payment() {
        name.sendKeys("Test");
        card.sendKeys("123456789");
        cvc.sendKeys("123");
        month.sendKeys("12");
        year.sendKeys("2025");
        payBtn.click();
    }

    public String getConfirmation() {
        return confirmMsg.getText();
    }
}