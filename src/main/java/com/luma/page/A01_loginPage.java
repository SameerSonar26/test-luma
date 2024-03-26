package com.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.Keyword;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class A01_loginPage {
	Keyword keyword = new Keyword();

	public A01_loginPage() {
		PageFactory.initElements(keyword.driver, this);
	}

	@FindBy(css = "a[href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/\"]")
	public WebElement loginlink;

	@FindBy(css = "input[id=\"email\"]")
	public WebElement emailTextInput;

	@FindBy(css = "input[name=\"login[password]\"]")
	public WebElement passwordTextInput;

	@FindBy(css = "button[id=\"send2\"]")
	public WebElement signInButton;

//	@FindBy(css = "div[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
//	public WebElement loginErrorText;
	
	@FindBy(css = "strong[id=\"block-new-customer-heading\"]")
	public WebElement loginErrorText;

	@FindBy(css = "li[class=\"greet welcome\"]>span[class*=\"in\"]")
	public WebElement loggedInText;

	public void clickOnLoginLink() {
		loginlink.click();
	}

	public void emailTextInput(String text1) {
		emailTextInput.sendKeys(text1);
	}

	public void passwordtextInput(String text1) {
		passwordTextInput.sendKeys(text1);
	}

	public void signbuttonclick() {
		signInButton.click();
	}

	public String logInErrorText() {
		return loginErrorText.getText();
	}

	public String loggedInText() {
		return loggedInText.getText();
	}

}
