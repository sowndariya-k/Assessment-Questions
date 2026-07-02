package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    public void enterSearchKeyword(String keyword){
        searchBox.sendKeys(keyword);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public boolean noProductMessageDisplayed(){
        return driver.getPageSource().contains("There is no product that matches the search criteria.");
    }
}