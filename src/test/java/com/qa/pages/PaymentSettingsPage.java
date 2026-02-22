package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentSettingsPage extends BaseTest {

	private static AppiumDriver driver;
    private static WebDriverWait wait; 
    
    
    @AndroidFindBy(className = "android.widget.ImageButton")private WebElement paymentBackBtn;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Daalchini\"])[1]")private WebElement paymentHeader;
    @AndroidFindBy(id = "app.daalchini.com:id/upi_payment")private WebElement razorpayBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/daalchini_wallet")private static WebElement dpBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/business_payment_name")private WebElement bpBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/sudexo_wallet")private WebElement pluxeeBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/card_payment")private WebElement creditdebitBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/wallet")private WebElement walletrazorpayBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/link_sudexo")private WebElement pluxeeLinkBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/unlink_sudexo")private WebElement pluxeeUnlinkBtn;

	
    
    public PaymentSettingsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    public PaymentSettingsPage NavigateBackToProfileScreen() {
		click(paymentBackBtn);
    	return this;
    }
    
    public String FetchPaymentScreenHeader() {

		//return getAttribute(welcomeText, "text");
		
		 if (paymentHeader != null) {
	     // Wait for the element to be visible before interacting with it
	     WebElement visibleElement = waitVisibility(paymentHeader);
	     return visibleElement.getAttribute("text");
	     } else {
	     System.err.println("paymentsettings screen Text element is not initialized.");
	     return null;
	        }
    }
    
    public PaymentSettingsPage SelectRazorpayUpi() {
		click(paymentHeader);
    	return new PaymentSettingsPage(driver);
    }
    
    public static void SelectDaalchiniPoints() {
  		try {
			try {
				try {
					click(dpBtn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	try {
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    
    public PaymentSettingsPage SelectBusinessPayments() {
  		click(bpBtn);
      	return new PaymentSettingsPage(driver);
      }
    
    public PaymentSettingsPage SelectPluxee() {
  		click(pluxeeBtn);
      	return new PaymentSettingsPage(driver);
      }
    
    public PaymentSettingsPage SelectRazorpayCreditDebitCards() {
  		click(creditdebitBtn);
      	return new PaymentSettingsPage(driver);
      }
    
    public PaymentSettingsPage SelectRazorpayWallets() {
  		click(pluxeeLinkBtn);
      	return new PaymentSettingsPage(driver);
      }
    
    public PaymentSettingsPage LinkPluxeeCard() {
  		click(walletrazorpayBtn);
      	return new PaymentSettingsPage(driver);
      }
    
    public PaymentSettingsPage UnlinkPluxeeCard() {
  		click(pluxeeUnlinkBtn);
      	return new PaymentSettingsPage(driver);
      }
    
    
    
    
    
}
