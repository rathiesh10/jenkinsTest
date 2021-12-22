package org.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.uttilities.BaseClass;

import io.cucumber.java.en.*;

public class FBPassResetStepDefinition extends BaseClass {
	@Given("user should launch chrome and load facebook page")
	public void user_should_launch_chrome_and_load_facebook_page() {
	    launchChrome();
	    loadUrl("https://www.facebook.com/");
	    winmax();
	}

	@When("user should select the forgot password button")
	public void user_should_select_the_forgot_password_button() {
	    WebElement w = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		w.click();
		
	}

	@When("user should type the valid number in the password reset page")
	public void user_should_type_the_valid_number_in_the_password_reset_page() {
	  WebElement w = driver.findElement(By.id("identify_email"));
	  w.sendKeys("1234567890");
	  
	}

	@When("user should click enter")
	public void user_should_click_enter() {
	  WebElement w = driver.findElement(By.xpath("//button[@value='1']"));
	  w.click();
	}

	@Then("user should navigate to the reset password page")
	public void user_should_navigate_to_the_reset_password_page() {
	 String currentUrl = driver.getCurrentUrl();
	 Assert.assertTrue("verify the url ", currentUrl.contains("recover"));
	 System.out.println("scenario is passed");
	}



}
