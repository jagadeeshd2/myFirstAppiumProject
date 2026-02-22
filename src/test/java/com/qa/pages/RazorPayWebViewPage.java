package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.GestureUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RazorPayWebViewPage {

	 private AndroidDriver driver;
	    private WebDriverWait wait;
	    private GestureUtil gesture;

	    public RazorPayWebViewPage(AndroidDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.gesture = new GestureUtil(driver); 
	        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(0)),this);
	    }
	    
	    @FindBy(xpath= "//svg@xlns='http://www.w3.org/2000/svg']")private WebElement cardPayment;
	    

	    public void SelectCardPayment() {
	    	cardPayment.click();
	    }
}
