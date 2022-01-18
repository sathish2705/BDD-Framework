package com.mindtree.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.ValidationBdd;
import com.mindtree.reusableComponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class validpageStepDef extends Base {
    WebDriver driver = null;
	ValidationBdd vp = null;

	public validpageStepDef() throws UtilityException, Exception {
		super();
	}

	@Before("@validpage")
	public void init() throws Exception {
		log = Logger.getLogger(validpageStepDef.class.getName());
		test = report.startTest("Log in");
		driver = initialize();
		System.out.println("Valid page");
		vp = new ValidationBdd(driver, log, test);
	}
	
	

	    @Given("^Open  Website with URl$")
	    public void open_website_with_url() throws Throwable {
	    	driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	    }


@Then("check whether the  tiltle is verified {string}")
public void check_whether_the_tiltle_is_verified(String title) throws PageObjectException, Exception {
	        vp.validate(title);
	    }
	    @After("@validpage")
		public void setReport() {
			report.endTest(test);
			report.flush();
			driver.quit();

	}
	
	}

