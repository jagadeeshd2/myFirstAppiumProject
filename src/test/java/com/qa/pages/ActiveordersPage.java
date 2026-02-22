package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

    public class ActiveordersPage  extends BaseTest{

	
	
	private   AppiumDriver driver;
    private static WebDriverWait wait;
        

    public ActiveordersPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Order Summary\").instance(0)") private WebElement activeOrderHeader;
    @AndroidFindBy(id = "app.daalchini.com:id/order_id_value") private WebElement orderIdText;
    
    public  String GetActiveOrdersHeaderText() {
    	
    return activeOrderHeader.getText();
    }
    public  String GetOrderIdText() {
    	
        return orderIdText.getText();
        }
    public boolean isOrderCreated() {
      try {
    	return orderIdText.isDisplayed();
    	
    } catch (Exception e) {
        return false;
    }
    }
    public boolean confirmPayment() {
        try {
            return orderIdText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
    
