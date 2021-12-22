package org.uttilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginpojo extends BaseClass {
     
       public FBLoginpojo() {
		PageFactory.initElements(driver, this);
       }
		@FindBy(id="email")
		private WebElement txtuser;
		
		@FindBy(id="pass")
		private WebElement txtpass;
		
		@FindBy(xpath="//button[@name='login']")
		private WebElement txtbtn;

		public WebElement getTxtuser() {
			return txtuser;
		}

		public WebElement getTxtpass() {
			return txtpass;
		}

		public WebElement getTxtbtn() {
			return txtbtn;
		}
		
		
		
		
}
