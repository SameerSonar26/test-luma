package com.luma.stepdefinition;

import org.testng.Assert;

import com.luma.page.A01_loginPage;

import io.cucumber.java.en.*;

public class A0_lumaLoginStepDefinition {
	A01_loginPage login = new A01_loginPage();
	// String exp_invalidCredentialErroMsg = "The account sign-in was incorrect or
	// your account is disabled temporarily. Please wait and try again later.";
	String exp_invalidCredentialErroMsg = "New Customers";

	@And("clickOnLoginLink")
	public void click_on_login_link() {
		login.clickOnLoginLink();
	}

	@Given("login credential {string}{string}")
	public void login_credential(String text1, String text2) {
		login.emailTextInput(text1);
		login.passwordtextInput(text2);
		login.signInButton.click();

	}

	@Then("getInvalidCredentialError")
	public void errorText() {
		// Thread.sleep(2000);
		String actErrorTextLogin = login.logInErrorText();
		Assert.assertEquals(actErrorTextLogin, exp_invalidCredentialErroMsg);
	}
	


}
