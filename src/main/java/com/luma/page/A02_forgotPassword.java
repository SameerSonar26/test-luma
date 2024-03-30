package com.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.Keyword;



public class A02_forgotPassword {
	Keyword keyword = new Keyword();

	public A02_forgotPassword() {
		PageFactory.initElements(keyword.driver, this);
	}

	@FindBy(css = "a[class=\"action remind\"]")
	public WebElement forgotPaassword;

	public void forgotPasswordLink() {
		forgotPaassword.click();
	}

	@FindBy(css = "input[id=\"email_address\"]")
	public WebElement emailIdTextField;

	public void email(String text1) {
		emailIdTextField.sendKeys(text1);
	}

	@FindBy(css = "button[class=\"action submit primary\"]")
	public WebElement resetButton;

	public void clickonResetPasswordButton() {
		resetButton.click();
	}

	@FindBy(css = "div[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
	public WebElement resetPasswordMsg;

	public String resetPasswordMsg() {
		keyword.waitForElementToBeVisible(resetPasswordMsg);
		return resetPasswordMsg.getText();

	}

	@FindBy(css = "div[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
	public WebElement emptyTextFieldErrorMsg;

	public String emptyForgotPasswordField() {
		keyword.waitForElementToBeVisible(emptyTextFieldErrorMsg);
		return emptyTextFieldErrorMsg.getText();

	}
}
