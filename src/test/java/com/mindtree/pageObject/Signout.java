package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.SignoutUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Signout extends SignoutUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Signout(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}public void clickLoginButton() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, signin, "home page", "signin", log, test);
		Thread.sleep(5000);
	}
	public void login(String Uid, String Pw) throws ReusableComponentException, Exception {
		WebDriverSupport.sendKeys(driver, email, "Account Log in", "Email entered ", log, test, Uid);
		WebDriverSupport.sendKeys(driver, password, "Account Log in", "password entered", log, test, Pw);
	}
	public void clicksignin() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, login, "Account Log in", "sign in button", log, test);
	}
	
	public void Logout() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, face, "img", "img", log, test);
		Thread.sleep(2000);
		WebDriverSupport.click(driver, logout, "logout", "logout", log, test);
	}
	
	public void verify() throws ReusableComponentException, Exception {
		try {
			if (driver.findElement(SignIn).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "Signed out", log);
				
			} else {
				ExtentLogUtilities.fail(driver, test, "signout failed", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
		}