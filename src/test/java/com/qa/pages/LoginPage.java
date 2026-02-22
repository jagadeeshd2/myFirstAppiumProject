package com.qa.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.BaseTest;
import com.qa.utils.ToastUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseTest {
	
	private AndroidDriver driver;
     private WebDriverWait wait ;
       

    public LoginPage( AndroidDriver driver) {
        
    	this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AndroidFindBy(accessibility = "test-Username") private WebElement usernameTxtFld;
	@AndroidFindBy(accessibility = "test-Password") private WebElement passwordTxtFld;
	@AndroidFindBy(accessibility = "test-LOGIN") private WebElement loginBtn;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") private WebElement errTxt; 
	
	// Locate the skip button using @FindBy annotation
    @AndroidFindBy(id = "app.daalchini.com:id/skipBtn")private WebElement nextButton;
    @AndroidFindBy(id = "app.daalchini.com:id/startBtn")private WebElement startButton;
    @AndroidFindBy(id = "app.daalchini.com:id/mobile_number")private WebElement MobTxtFld;
	@AndroidFindBy(id = "app.daalchini.com:id/btn_continue")private WebElement pressCntBtn;
	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\'Invalid Otp\']") private WebElement errorToast;
	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Invalid Otp']") private WebElement otp1;
	@AndroidFindBy(uiAutomator  = "new UiSelector().text(\"Hello\")")private  WebElement welcomeText;
	
	//@AndroidFindBy(xpath = "//xpath of enterotp in daalchini app")private WebElement EnterOTP;
	
	// Locate each OTP field using @AndroidFindBy annotation
	/*@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[1]")
    private WebElement otpField1;

	//Tagname[@AttibuteName = 'value']
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[2]")
    private WebElement otpField2;

	@AndroidFindBy(xpath= "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[3]")
    private WebElement otpField3;

	@AndroidFindBy(xpath= "//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[4]")
    private WebElement otpField4;*/
	@AndroidFindBy(id = "app.daalchini.com:id/btn_continue")private WebElement submitOTP;
	//@AndroidFindBy(xpath = "//android.widget.Toast[@text='Invalid Otp']")private WebElement errormessage;
	//@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")private static WebElement whileUsingtheApp;
	
	

	
	public void enterUserName(String username) {
		wait.until(ExpectedConditions.visibilityOf(usernameTxtFld));
		usernameTxtFld.sendKeys(username);
		}
		
//	public LoginPage enterPassword(String password) {
//		sendKeys(passwordTxtFld, password);
//		return new LoginPage(driver);
//	}
//	public ProductsPage pressLoginBtn() {
//		click(loginBtn);
//		return new ProductsPage(driver);
//	}
	public String getErrTxt() {
		wait.until(ExpectedConditions.visibilityOf(errTxt));
		return errTxt.getText();
	}
	
	 public void onboardingscreen() {
			wait.until(ExpectedConditions.visibilityOf(nextButton));
			nextButton.click();
		}

	 public void StartApp() {
			
			wait.until(ExpectedConditions.visibilityOf(startButton));
			startButton.click();
		}
	public void EnterMob(String MobileNumber) {
		wait.until(ExpectedConditions.visibilityOf(MobTxtFld));

		MobTxtFld.sendKeys( MobileNumber);
		}
	
    public void Continuebutton() {
		wait.until(ExpectedConditions.visibilityOf(pressCntBtn));
        pressCntBtn.click();
		}
    public String getInvalidOtpToast() {
    	
    	   try{
    		   WebElement toast = wait.until(
    	   
                   ExpectedConditions.presenceOfElementLocated(
                           By.xpath("//android.widget.Toast[contains(@text,'Invalid Otp')]")));
  
           // Toast text comes from its "name" attribute
           return toast.getAttribute("name");  
               } catch (Exception e) {
                return null;
        }
        }
    public String GetWelcomeText() {
		
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
			return welcomeText.getText();
	    }
 /*public LoginPage OtpTxtFld(String OTP) {
		
		sendKeys(EnterOTP, OTP);
		return this;
	
}*/
// public void enterotp(String otp) {
//	 try {
//         // Wait for the OTP input field to be visible
//		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//         WebElement otpField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[1]")));
//         WebElement otpField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[2]")));
//         WebElement otpField3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[3]")));
//         WebElement otpField4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText[4]")));
//         otpField1.sendKeys(Character.toString(otp.charAt(0)));
//         otpField2.sendKeys(Character.toString(otp.charAt(1)));
//         otpField3.sendKeys(Character.toString(otp.charAt(2)));
//         otpField4.sendKeys(Character.toString(otp.charAt(3)));
//     
//         // Enter the OTP
//         System.out.println("OTP entered successfully.");   
// 
//     } catch (Exception e) {
//         e.printStackTrace();
//         System.out.println("Failed to enter OTP: " + e.getMessage());
//     }}
    
    public void enterOtp(String otp) {
    	
        if (otp.length() != 4) {
            throw new IllegalArgumentException("OTP must be 4 digits");
        }

        try {
            // Find all OTP input boxes at once
            List<WebElement> otpFields = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//android.widget.LinearLayout[@resource-id='app.daalchini.com:id/pinview']/android.widget.EditText")
                )
            );

            if (otpFields.size() < 4) {
                throw new RuntimeException("Expected 4 OTP boxes but found: " + otpFields.size());
            }

            // Enter OTP digit by digit
            for (int i = 0; i < 4; i++) {
                otpFields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            }

            System.out.println("OTP entered successfully.");

        } catch (Exception e) {
            System.out.println("Failed to enter OTP: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
 
  
 
    public String getErrorToast() {
        return ToastUtils.getToastMessage(driver);
    }

 
  

 
// public void pressDeviceBackButton() {
//	 //driver.navigate().back();
//	try {  driver2.pressKey(new KeyEvent(AndroidKey.BACK));
//	}catch(Exception e) {  
//		System.out.println("appium not pressed backbutton");
//	}
// }
 public void SubmitButton() {
	   try { driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOf(submitOTP));
		submitOTP.click();}
	   catch(Exception e) {
		   e.printStackTrace();
	   }
		}


 public void navigateBackToPreviosScreen() {
	driver.navigate().back();
 }
 
}
