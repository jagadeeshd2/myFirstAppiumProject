package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import com.qa.utils.GestureUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage {
	

    private AndroidDriver driver;
    private WebDriverWait wait;
    private GestureUtil gesture;

  
    @AndroidFindBy(id="app.daalchini.com:id/card_payment") private WebElement razorPayOption; //razorpay card payments
    @AndroidFindBy(id="app.daalchini.com:id/sudexo_wallet") private WebElement SodexoOption;
    @AndroidFindBy(id="app.daalchini.com:id/business_payment_layout") private WebElement corporateWallet ;
    @AndroidFindBy(id="app.daalchini.com:id/daalchini_wallet") private WebElement dpWallet ;
    @AndroidFindBy(id="app.daalchini.com:id/unlink_sudexo") private WebElement sodexoLinkedbtn ;
    @AndroidFindBy(id="app.daalchini.com:id/daalchini_wallet_desc") private WebElement daalchiniWalletBalance ;
    @AndroidFindBy(id="app.daalchini.com:id/business_payment_desc") private WebElement corporteWalletBalance ;

    
    
    
    public PaymentPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.gesture = new GestureUtil(driver);
    }
    public boolean isDaalchiniWalletAvailable() {
    	return dpWallet.isDisplayed();
    }
    public double getDaalchiniWalletBalance() {
    	String balance = daalchiniWalletBalance.getText().replace("₹", "D").trim();
    	 return Double.parseDouble(balance);
    }
    public boolean hasSufficientDaalchiniBalance(double orderAmount) {
    	return getDaalchiniWalletBalance() >= orderAmount;
    }
    public boolean payWithDaalchiniWallet(double orderAmount) {

        if (!hasSufficientDaalchiniBalance(orderAmount)) {
            throw new SkipException("❌ Insufficient Daalchini Wallet balance");
        }
		return false;
    }
    public void selectDaalchiniWallet(){
     wait.until(ExpectedConditions.elementToBeClickable(dpWallet));
    	dpWallet.click();
    }
    public boolean isCorporateWalletLinked() {
    	return corporateWallet.isDisplayed();
    }

    public void selectCorporateWallet(){
    	corporateWallet.click();
    }
    public boolean isRazorpayAvailable(){
    	return razorPayOption.isDisplayed();
    }
    public void selectRazorpay(){
    	razorPayOption.click();
    }
    public void scrollToRazorpayCardPayments() {
    	gesture.scrollUntilVisibleWE(razorPayOption);
    }
    public boolean isSodexoLinked() {
    	return sodexoLinkedbtn.isDisplayed();
    }
    public void selectSodexo() {
    	SodexoOption.click();
    }
}
