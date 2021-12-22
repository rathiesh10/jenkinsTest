package org.stepdefinition;

import java.io.IOException;

import org.apache.poi.common.usermodel.Fill;
import org.junit.Assert;
import org.uttilities.BaseClass;
import org.uttilities.FBLoginpojo;

import io.cucumber.java.en.*;


public class FBLoginStepDefinition extends BaseClass {

@Given("user should launch the browser and load the fb page")
public void user_should_launch_the_browser_and_load_the_fb_page() {
       launchChrome();
       loadUrl("https://www.facebook.com/");
       winmax();
}

@When("user should type the username in the facebook page")
public void user_should_type_the_username_in_the_facebook_page() throws IOException {
   FBLoginpojo f = new FBLoginpojo();
   fill(f.getTxtuser(), getData(1, 0));
}

@When("user should type the password in the facebook page")
public void user_should_type_the_password_in_the_facebook_page() {
	 FBLoginpojo f = new FBLoginpojo();
	 fill(f.getTxtpass(), "greens@123");
}

@When("user should click the login button")
public void user_should_click_the_login_button() throws InterruptedException {
	 FBLoginpojo f = new FBLoginpojo();
	 btnClick(f.getTxtbtn());
	 Thread.sleep(2000);
}

@Then("user should navigate to incorrect credentials page")
public void user_should_navigate_to_incorrect_credentials_page() {
   String currentUrl = driver.getCurrentUrl();
   Assert.assertTrue("verify the url", currentUrl.contains("privacy"));
   System.out.println("scenario 1 is passed");
   
}

}
