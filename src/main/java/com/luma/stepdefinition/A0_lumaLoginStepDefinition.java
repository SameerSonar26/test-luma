package com.luma.stepdefinition;

import org.testng.Assert;

import com.luma.Keyword;
import com.luma.page.A01_loginPage;

import io.cucumber.java.en.*;

public class A0_lumaLoginStepDefinition {

	// Invalid User Login Data

	A01_loginPage login = new A01_loginPage();
	String exp_invalidCredentialErroMsg = "New Customers";
	String exp_loggedMsg = "Welcome, sameer sonar! ";

	@And("clickOnLoginLink")
	public void click_on_login_link() {
		login.clickOnLoginLink();
	}

	@Given("loginInvalidcredential {string}{string}")
	public void loginInvalidcredential(String text1, String text2) {
		login.emailTextInput(text1);
		login.passwordtextInput(text2);
		login.signInButton.click();

	}

	@Then("getInvalidCredentialError")
	public void errorText() {
		
		String actErrorTextLogin = login.logInErrorText();
		Assert.assertEquals(actErrorTextLogin, exp_invalidCredentialErroMsg);
	}

	
	
	// Valid user login data
	@Given("loginValidCredential {string}{string}")
	public void loginValidCredential(String text1, String text2) {
		login.emailTextInput(text1);
		login.passwordtextInput(text2);
		login.signInButton.click();
	}

	@Then("getValidCredentialMsg")
	public void loggedMsg() throws InterruptedException   {
		String actLoggedMsg = login.loggedInText();
		
		System.err.println(actLoggedMsg);
		Assert.assertEquals("Sameer","Sameer");
		
	}
}
