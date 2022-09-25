package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // PageFactory class help to instantiate WebElement
	}
	
	// This is not a good choice of attribute for xpath, Please use id, name, class name only
	@FindBy(xpath = "//img[@alt='Mount Sinai']")
	WebElement logo;
	
	public boolean logoDisplayed() {
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? " + flag);
		return flag;
	}
	
	
	
	

}

