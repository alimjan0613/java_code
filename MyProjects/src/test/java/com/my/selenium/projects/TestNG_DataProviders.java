package com.my.selenium.projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNG_BeforeClassAnnotations1 {
	@BeforeClass
	public void setUp() {
		System.out.println("\n TestNG before class annotation1 : this runs once ,  before class");
	}
	@AfterClass
	public void cleanUp() {
		System.out.println("\\n TestNG before class annotation1 : this runs once ,  after class");
	}
	

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\n TestNG before class annotation1 : this runs before evry mothod");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\n TestNG before class annotation1 : this runs after evry mothod");
	}
	
	
	@Test
	public void f() {
		System.out.println("Test method one");
	}

	

}
