package com.learning.selenium.firstproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHp {
	
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver ;
		
		 

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement userNameElem = driver.findElement(By.id("txtUsername"));
		userNameElem.clear();
		Thread.sleep(1 * 1000);
		userNameElem.sendKeys("admin");
		Thread.sleep(1 * 1000);

		WebElement passwordElem = driver.findElement(By.id("txtPassword"));
		passwordElem.clear();
		passwordElem.sendKeys("admin");
		Thread.sleep(1 * 1000);
		WebElement buttonElem = driver.findElement(By.id("btnLogin"));
		buttonElem.submit();
		Thread.sleep(1 * 1000);

		// step 2 : click Assign leave button
		WebElement assignElem = driver.findElement(
				By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[1]/div/a/img"));
		assignElem.click();
		WebElement empNameElem = driver.findElement(By.id("assignleave_txtEmployee_empName"));
		empNameElem.sendKeys("alimjan");
		Thread.sleep(1 * 1000);
		Select dropdown = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));
		
		dropdown.selectByVisibleText("Maternity US");
		Thread.sleep(1 * 1000);
		dropdown.selectByVisibleText("Vacation US");
		// enter from date 
		WebElement fDateElem = driver.findElement(By.id("assignleave_txtFromDate")); // locating from date box
		fDateElem.clear();
		fDateElem.sendKeys("6-2018");// enter month and year
		Thread.sleep(1 * 1000);
		// enter to date------
		WebElement tDateElem = driver.findElement(By.id("assignleave_txtToDate"));
		tDateElem.clear();
		tDateElem.sendKeys("2018-6-13");
		tDateElem.click();
		Thread.sleep(1 * 1000);
		// leave comment------
		WebElement commentElem = driver.findElement(By.name("assignleave[txtComment]"));
		commentElem.sendKeys("oh ... i cant imagine that . im really happy that i can also do it. thanks Allah!!");
		Thread.sleep(1*1000);
		// click assign button ---------
		WebElement assignButElem = driver.findElement(By.id("assignBtn"));
		assignButElem.click();

		Thread.sleep(1 * 1000);
		driver.close();
		driver.quit();

	

	
	}



	}


