package com.luma.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

import com.luma.Keyword;
import com.luma.page.A02_forgotPassword;

import io.cucumber.java.en.*;

public class A02_forgotPasswordStepDefinitation {
	A02_forgotPassword forgotPass = new A02_forgotPassword();
	String expForgotPasswordMsg = "If there is an account associated with saneersonar1@gmail.com you will receive an email with a link to reset your password.";
	String expEmptyTextFieldErrorMsg = "Please enter your email.";
	Keyword keyword = new Keyword();

	@And("clickonForgotPassWordLink")
	public void clickon_forgot_pass_word_link() {
		forgotPass.forgotPasswordLink();
	}

	@Given("validEmailID")
	public void valid_email_id() {
		forgotPass.email("saneersonar1@gmail.com");
	}

	@Given("clickOnResetPasswordButton")
	public void click_on_reset_password_button() {
		forgotPass.clickonResetPasswordButton();
	}

	@Then("GetResetPasswordMsg")
	public void get_reset_password_msg() throws IOException {
		String actForgotPasswordMsg = forgotPass.resetPasswordMsg();
		Assert.assertEquals(actForgotPasswordMsg, expForgotPasswordMsg);
		keyword.screenShot();
	}

	// Empty Text field
	@Given("emptyEmailID")
	public void empty_Email_ID() {
		forgotPass.email("");
	}

	@Then("GetEmptyEmailIDErrorMsg")
	public void Get_Empty_Email_ID_Error_Msg() throws IOException {
		String actEmptyFieldErrorMsg = forgotPass.emptyForgotPasswordField();
		Assert.assertEquals(actEmptyFieldErrorMsg, expEmptyTextFieldErrorMsg);
		keyword.screenShot();
	}

}
