package com.qa.pages;

import java.time.Duration;

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

public class ProfilePage  extends BaseTest {
	
	private AndroidDriver driver;
    private  WebDriverWait wait; 
    
    
    @AndroidFindBy(id = "app.daalchini.com:id/edit_profile")private WebElement profileEdit;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='SUCCESS']")private  WebElement confirmationToast;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='app.daalchini.com:id/payment_settings']/android.widget.RelativeLayout")private static WebElement paymentSettings;
    @AndroidFindBy(id = "app.daalchini.com:id/bp_balance")private  WebElement checkBpBalance;
    @AndroidFindBy(id = "app.daalchini.com:id/dp")private static WebElement openDpHistory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daalchini wallet']")private  WebElement dpHistoryHeader;
    @AndroidFindBy(id = "app.daalchini.com:id/points")private  WebElement checkDpBalance;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\'app.daalchini.com:id/fav']/android.view.ViewGroup")private  WebElement helpNSupport;
    @AndroidFindBy(id = "app.daalchini.com:id/refer")private  WebElement referNEarn;
    @AndroidFindBy(id = "app.daalchini.com:id/faq")private  WebElement faq;
    @AndroidFindBy(id = "app.daalchini.com:id/rate")private  WebElement ratingInPlaystore;
    @AndroidFindBy(id = "app.daalchini.com:id/about_us")private  WebElement aboutUs;
    @AndroidFindBy(id = "app.daalchini.com:id/logout")private  WebElement logOut;
    @AndroidFindBy(id = "app.daalchini.com:id/current_device")private  WebElement logOutFromCurrentDevice;
    @AndroidFindBy(id = "app.daalchini.com:id/all_devices")private  WebElement logOutFromAllDevices;
    @AndroidFindBy(id = "app.daalchini.com:id/cancel")private  WebElement cancellogOutPopup;
    @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"Profile\")")private  WebElement profileScreenHeader;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Payment method set to default']")private  WebElement defaultPgConfirmToast;
    @AndroidFindBy(id = "app.daalchini.com:id/bplink")private  WebElement bpHistoryBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\'Business payment ']")private  WebElement bpHistoryScreenHeader;
    @AndroidFindBy(id = "app.daalchini.com:id/unlink")private  WebElement bpUnlink;
    @AndroidFindBy(id = "app.daalchini.com:id/buttonOk")private  WebElement bpUnlinkNoPopup;
    @AndroidFindBy(id = "app.daalchini.com:id/confirm_button")private  WebElement bpUnlinkYesPopup;
    @AndroidFindBy(id = "app.daalchini.com:id/buttonOk")private  WebElement unlinkrequestedOkayPopup;
    @AndroidFindBy(className = "android.widget.ImageButton")private  WebElement bpHistoryBackbutton;
    @AndroidFindBy(id = "app.daalchini.com:id/bplink")private  WebElement linkBp;
    @AndroidFindBy(id = "app.daalchini.com:id/btn_continue")private  WebElement continuelinkingBp;
    @AndroidFindBy(id = "app.daalchini.com:id/enterEmail")private  WebElement enterEmailIdBp;
    @AndroidFindBy(id = "app.daalchini.com:id/linkaccount")private  WebElement linkAccountBpBtn;
   /* @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[1]")private static WebElement verifyOtpBpTxtfld1;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[2]")private static WebElement verifyOtpBpTxtfld2;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[3]")private static WebElement verifyOtpBpTxtfld3;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[4]")private static WebElement verifyOtpBpTxtfld4;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[5]")private static WebElement verifyOtpBpTxtfld5;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[6]")private static WebElement verifyOtpBpTxtfld6;*/
    @AndroidFindBy(id = "app.daalchini.com:id/btn_continue")private static WebElement verifyAccountBpBtn;

    
    
    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
          wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public ProfilePage NavigateToProfileEditScreen() {
		click(profileEdit);
    	return new ProfilePage(driver);
    }
    
//    public String GetProfileUpdateConfirmText() {
//		
//		//return getAttribute(welcomeText, "text");
//		
//    if (confirmationToast != null) {
//	            // Wait for the element to be visible before interacting with it
//    WebElement visibleElement = waitVisibility(confirmationToast);
//	return visibleElement.getAttribute("text");
//	} else {
//	System.err.println("profile Update Confirmation Text element is not initialized.");
//	return null;
//	}
//
//}
    
    public ProfilePage NavigateToPaymentSettingsScreen() {
		click(paymentSettings);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage NavigateToBusinessPaymentsHistory() {
		click(bpHistoryBtn);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage FetchBpBalance() {
		click(checkBpBalance);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage NavigateToDpHistoryScreen() {
		click(openDpHistory);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage FetchDaalchiniWalletBalance() {
		click(checkDpBalance);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage ClickHelpAndSupport() {
		click(helpNSupport);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage NavigateToReferAndEarnScreen() {
		click(referNEarn);
    	return new ProfilePage(driver);
    }
    
    public ProfilePage NavigateToFaqScreen() {
  		click(faq);
      	return new ProfilePage(driver);
      }
    
    public ProfilePage NavigateToPlaystoreToRateApp() {
  		click(ratingInPlaystore);
      	return new ProfilePage(driver);
      }

    public ProfilePage NavigateToDaalchiniWebsite() {
  		click(aboutUs);
      	return new ProfilePage(driver);
      }

    public ProfilePage ClickOnLogout() {
  		click(logOut);
      	return new ProfilePage(driver);
      }

    public ProfilePage DoLogoutFromCurrentDevice() {
  		click(logOutFromCurrentDevice);
      	return new ProfilePage(driver);
      }
    
    public ProfilePage DoLogoutFromAllDevices() {
  		click(logOutFromAllDevices);
      	return new ProfilePage(driver);
      }
    
    public ProfilePage CloseLogout() {
  		click(cancellogOutPopup);
      	return new ProfilePage(driver);
      }
    
    public String FetchProfileScreenHeader() {
    	return profileScreenHeader.getText();
      }
    
    
   public String FetchDeafaultPgConfirmationToast() {
    	return wait.until(ExpectedConditions.visibilityOf(defaultPgConfirmToast)).getText();
      }
   
   
//   public String FetchBpHistoryHeader() {
//   
//     }
   
   
   public ProfilePage DoUnlinkBusinessPayments() {
 		click(bpUnlink);
     	return this;
     }
   
   public ProfilePage CloseBpUnlinkPopup() {
		click(bpUnlinkNoPopup);
    	return this;
     }
   
   public ProfilePage ConfirmBpUnlinking() {
		click(bpUnlinkYesPopup);
   	return this;
     }
   
   public ProfilePage UnlinkRequestedConfirmPopup() {
		click(unlinkrequestedOkayPopup);
  	return this;
     }
   
   public ProfilePage NavigateToProfileScreenFromBpscreen() {
		click(bpHistoryBackbutton);
   	return this;
     }
   
   public ProfilePage  DoLinkBusinessPayments() {
		click(linkBp);
	return this;
     }
   
   public ProfilePage  ContinueBpLinkinProcess() {
		click(continuelinkingBp);
	return this;
     }
   
   public ProfilePage  EnterBusinessMailId(String businessEmail) {
	    
			type(enterEmailIdBp, businessEmail );
			return this;
     }
   
   public ProfilePage  SubmitBusinessMail() {
		click(linkAccountBpBtn);
	return this;
    }
   
   
   public void EnterBpOtp(String otp) {
		 try {
	         // Wait for the OTP input field to be visible
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	         WebElement verifyOtpBpTxtfld1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[1]")));
	         WebElement verifyOtpBpTxtfld2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[2]")));
	         WebElement verifyOtpBpTxtfld3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[3]")));
	         WebElement verifyOtpBpTxtfld4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[4]")));
	         WebElement verifyOtpBpTxtfld5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[5]")));
	         WebElement verifyOtpBpTxtfld6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[6]")));

	         verifyOtpBpTxtfld1.sendKeys(Character.toString(otp.charAt(0)));
	         verifyOtpBpTxtfld2.sendKeys(Character.toString(otp.charAt(1)));
	         verifyOtpBpTxtfld3.sendKeys(Character.toString(otp.charAt(2)));
	         verifyOtpBpTxtfld4.sendKeys(Character.toString(otp.charAt(3)));
	         verifyOtpBpTxtfld5.sendKeys(Character.toString(otp.charAt(4)));
	         verifyOtpBpTxtfld6.sendKeys(Character.toString(otp.charAt(5)));

	     
	         // Enter the OTP
	         System.out.println("OTP entered successfully.");   
	 
	     } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("Failed to enter OTP: " + e.getMessage());
	     }}
   
   
   public ProfilePage  VerifyBusinessOtp() {
		click(verifyAccountBpBtn);
	    return this;
        }
   
//   public String FetchDpHistoryHeader() {
//	   	
//			//return getAttribute(welcomeText, "text");
//			
//	   if (dpHistoryHeader != null) {
//		            // Wait for the element to be visible before interacting with it
//	   WebElement visibleElement = waitVisibility(dpHistoryHeader);
//		return visibleElement.getAttribute("text");
//		} else {
//		System.err.println("Dp History Header Text element is not initialized.");
//		return null;
//		}
//	     }
// 
}


