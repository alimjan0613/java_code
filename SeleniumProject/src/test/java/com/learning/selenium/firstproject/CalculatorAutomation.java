package com.learning.selenium.firstproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorAutomation {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");// open chrome driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // maximize the window

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2 * 1000); // stops the test for five second
		driver.close();// close the browser
	}

	@Test
	public void calculaterTest() throws Exception {
		driver.get("http://www.mortgagecalculator.net/");
		//String websiteTitle = driver.getTitle();
		//System.out.println("This web site title is : " + websiteTitle);
		//String expetedWebsiteTitle = "Mortgage Calculator 2018 - FREE & Easy Calculator Tool";
		//assertEquals(websiteTitle, expetedWebsiteTitle);
		Thread.sleep(2 * 1000);
		WebElement moneySymboleElem = driver.findElement(By.id("currency"));
		moneySymboleElem.click();
		Thread.sleep(2 * 1000);
		Select dropdown = new Select(driver.findElement(By.id("currency")));
		dropdown.selectByVisibleText("€");
		Thread.sleep(2 * 1000);
		dropdown.selectByVisibleText("$");

		// step 2 : locate amount element and enter 100000
		WebElement amountElement = driver.findElement(By.id("amount"));
		amountElement.clear(); // clear the text box
		Thread.sleep(1*1000);
		amountElement.sendKeys("1000000"); // enter one million to the amount box
		
		// step 3 : locate the year and month element .
		WebElement yearElement =driver.findElement(By.id("amortizationYears"));
		yearElement.clear();
		yearElement.sendKeys("70");
		Thread.sleep(1*1000);
		
		WebElement monthElement = driver.findElement(By.id("amortizationMonths")); // locate month element
		monthElement.clear();
		Thread.sleep(1*1000);
		monthElement.sendKeys("12");
		
		WebElement intYearElement = driver.findElement(By.id("interestTermYears"));
		intYearElement.clear();
		Thread.sleep(1*1000);
		intYearElement.sendKeys("60");
		
		WebElement intMonthElement = driver.findElement(By.id("interestTermMonths"));
		intMonthElement.sendKeys("30");
		Thread.sleep(1*1000);
		
		Select intDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"interestType\"]")));
		Thread.sleep(1*1000);
		intDropdown.selectByIndex(1);
		
		WebElement intRateElement = driver.findElement(By.id("rate"));
		intRateElement.clear();
		
		intRateElement.sendKeys("0.12");
		
// 2.49.59
	}

}


