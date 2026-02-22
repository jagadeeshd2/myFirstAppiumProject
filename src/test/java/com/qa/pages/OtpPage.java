package com.qa.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OtpPage extends BaseTest{
	AppiumDriver driver;
	private static WebDriverWait wait;

	

	public OtpPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void enterOtp(String otp) {
		// code to enter the OTP
	}
	public OtpPage pressSubmitBtn() {
		// code to submit the OTP and return the Home page
		return new OtpPage(driver);
	}

}
