														package com.qa.pages;

 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;
import com.qa.utils.GestureUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PastOrderPage  extends  BaseTest{
	private AndroidDriver driver;
    private static WebDriverWait wait;
    private GestureUtil gesture;
    
    
    
    @AndroidFindBy(xpath = "app.daalchini.com:id/grandtotal")
    private WebElement grandTotalText;
    @AndroidFindBy(id = "app.daalchini.com:id/oder")
    private WebElement fetchOrderId;
    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement  pastOrderBackBtn;
    @AndroidFindBy(className = "app.daalchini.com:id/cencel_button")
    private WebElement cancelOrderBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/help_support")
    private WebElement helpNSupportBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/pick_code")
    private WebElement pickupCodeText;   
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Test Machine 5 Noida City 23\"]")
    private WebElement vmAddressText;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Orders\")")
    private WebElement pastOrdersHeader; 
     
    public PastOrderPage(AndroidDriver driver) {
        this.driver = driver;
        this.gesture = new GestureUtil(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
  
    
    
    public String FetchGrandTotalAmount() {
		return getAttribute(grandTotalText,"text" );
	}
    public String FetchOrderId() {
    	return getAttribute(fetchOrderId,"text" );    	 
    }
    public void NavigateBackToHomescreen() {
    	pastOrderBackBtn.click();
    }
    public void  CancelYourOrder() {
    	cancelOrderBtn.click();
    }
    public void NavigateToCstWhatsappChat() {
    	helpNSupportBtn.click();
    }
    public String FetchPickupCode() {
    	 
    	 return getAttribute(pickupCodeText,"text" ); 
    }
    public PastOrderPage FetchVmAddressOnPostOrderScreen(String VmAddress) {
    	type(vmAddressText,VmAddress);
    	return  this;
    }
    public String fetchPastOrdersHeader() {
    	return pastOrdersHeader.getText();
    }
    
}
