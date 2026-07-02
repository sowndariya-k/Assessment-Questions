package com.java.selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Question1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement login=driver.findElement(By.xpath("//a[@id='login2']"));
		login.click();
		WebElement userName=driver.findElement(By.id("loginusername"));
		userName.sendKeys("sowndariya");
		WebElement password=driver.findElement(By.id("loginpassword"));
		password.sendKeys("Sow@911!");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("login");

		String expect ="Welcome sowndariya";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));

		if(expect.equals(welcome.getText())) {
			System.out.println("login successful");
		}
		else {
			System.out.println("login failed");
		}
			
		//navigate Question 2
		
		driver.findElement(By.xpath("//a[3]")).click();
		
		List<WebElement> allLaptops=wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='tbodyid']//h4/a")));
		List<String> laptopname = new ArrayList<>();
		for(WebElement lap: allLaptops) {
			laptopname.add(lap.getText());
			Collections.sort(laptopname);
		}
		Collections.sort(laptopname);
		
		//3. add to cart Macbook Pro
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")).click();
		System.out.println("MacBook Pro click");
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
		System.out.println("Add to cart click");
		
		//ai used for alert portion
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("cartur")).click();
		WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));
		
		WebElement productPrice = driver.findElement(By.xpath("//td[text()='1100']"));
		
		if (productTitle.getText().equals("MacBook Pro") && productPrice.getText().equals("1100")) {
		    System.out.println("Product added to cart");
		    System.out.println("MacBook Pro added to cart.");
		} 
		else {
		    System.out.println("Product not added correctly");
		}
		
		
		//4. 
		
		driver.quit();
	}
}
