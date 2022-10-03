package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class HomePageTest extends BaseClass {
	
	@Test(enabled = false)
	public void logoTest01() {
		homePage.logoDisplayed();
	}
	
	// new
	@Test(enabled = false)
	public void logoTest02() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Mount Sinai']"));
		boolean flag = logo.isDisplayed();
		// System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");	// error message will be appeared when the assertion failed 
	}
	
	// new
	@Test(enabled = false)
	public void logoTest03() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Mount Sinai']"));
		boolean flag = logo.isDisplayed();
		// System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertFalse(false, "Application Logo is not displayed .....");	// error message will be appeared when the assertion failed 
	}
	
	// new
	// This test case will be failed
	@Test(enabled = false)
	public void logoTest04() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Mount Sinai']"));
		boolean flag = logo.isDisplayed();
		// System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertFalse(true, "Application Logo is not displayed .....");	// error message will be appeared when the assertion failed 
	}
	
	// A regular title test
	@Test(enabled = false)
	public void use_of_getTitle_method01() {
		System.out.println("The title of the Page is: " + driver.getTitle());
	}
	
	// new
	// Will Pass
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion01() {
		String expected = "Mount Sinai Health System - New York City | Mount Sinai - New York";
  		String actual = driver.getTitle();
  		System.out.println("Home Page Title is: "+actual);
  		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ..."); // Hard Assertion
  		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 1 is: " + currentURL);
	}
	
	// new
	// Will fail
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion02() {
		String expected = "Mount Sinai Health System - New York City |  Mount Sinai - New York";
  		String actual = driver.getTitle();
  		System.out.println("Home Page Title is: "+actual);
  		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ..."); // Hard Assertion
  		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 2 is: " + currentURL);
	}
	
	// new
	// will pass
	@Test(enabled = true)
	public void use_of_getTitle_method_with_soft_assertion() {
		String expected = "Mount Sinai Health System"; // WHICH is wrong
  		String actual = driver.getTitle();
  		System.out.println("Home Page Title is: "+actual);
  		SoftAssert softAssert  = new SoftAssert(); // Soft Assertion, mainly interview question, not used generally
  		softAssert.assertEquals(actual, expected, "Home Page Title doesn't match ..."); // Soft Assertion
  		// The above condition is not true, but because of soft assertion the execution go to next line
  		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 3 is: " + currentURL);
	}
		
	// new
	@Test(enabled = false)
	public void mouseHoverActionOnAboutUs() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space(text())='About Us' and @class='hidden-xs dropdown']"));
		Thread.sleep(5000);
		actions.moveToElement(aboutUs).build().perform(); // this syntax interview question
		Thread.sleep(5000);
		
	}
	
	// similar like above, nothing different, extra
	@Test(enabled = false)
	public void mouseHoverActionOnOurLocations() throws InterruptedException {
		Actions actions = new Actions(driver); // very important interview question
		WebElement ourLocations = driver.findElement(By.xpath("//a[normalize-space(text())='Our Locations' and @class='hidden-xs dropdown']"));
		Thread.sleep(2000);
		actions.moveToElement(ourLocations).build().perform();
		Thread.sleep(6000);	
		System.out.println("\nThe text of this web element is: "+ ourLocations.getText());
	}
	
}

