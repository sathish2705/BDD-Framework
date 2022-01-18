package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.airportUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class AirportBdd extends airportUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public AirportBdd(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Airport() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, airport , "airport", "airport", log, test);
	}
	public void Outstation(String fro) throws ReusableComponentException, Exception {

		WebDriverSupport.click(driver, from, "from", "from place", log, test);
		WebDriverSupport.sendKeys(driver, from, "from", "place", log, test, fro);
		WebDriverSupport.click(driver, desti, "from", "from", log, test);
		}
	public void sel() throws ReusableComponentException, Exception {
		
		Select tb=new Select(driver.findElement(trip));
		tb.selectByValue("pick_airport");
	}
	public void add() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, droP, "address", "dropaddress", log, test);
	}
	public void enadd(String Add) throws ReusableComponentException, Exception {

		WebDriverSupport.sendKeys(driver, droP, "address", "dropaddress", log, test, Add);
		Thread.sleep(2000);
		WebDriverSupport.click(driver, Address, "address", "dropaddress", log, test);
		Thread.sleep(2000);
	}
	
	public void selecT() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, select, "select", "selected", log, test);
		Thread.sleep(2000);
	}
	public void selecr() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, selectcar, "select", "select car", log, test);
	}
	public void verify() throws ReusableComponentException, Exception {

		try {
		
			if (driver.findElement(bookingdetail).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "booking detail displayed ", log);
				WebDriverSupport.click(driver, home, "home page", "home page", log, test);
			} else {
				ExtentLogUtilities.fail(driver, test, " booking detail is not displayed", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
	
		
	
}


