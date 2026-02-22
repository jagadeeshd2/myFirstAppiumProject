package com.qa.pages;

 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Capabilities;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyCartPage  extends  BaseTest{ 
	
	public   AndroidDriver driver;
    private static WebDriverWait wait;
    
    
    
    
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"My Cart\")")
    private WebElement myCartHeader;
    @AndroidFindBy(id = "app.daalchini.com:id/clear_cart")
    private WebElement clearCart;
    @AndroidFindBy(id = "app.daalchini.com:id/add_item")
    private WebElement addItem;
    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement myCartBackbutton;
    @AndroidFindBy(id = "app.daalchini.com:id/change_payment_option")
    private WebElement pgChangeBtn;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='app.daalchini.com:id/coupon_card']/android.widget.RelativeLayout")
    private WebElement couponList;   
    @AndroidFindBy(id = "app.daalchini.com:id/total_amount")
    private WebElement totalAmountText;
    @AndroidFindBy(id = "app.daalchini.com:id/btn_place_order")
    private WebElement placeOrderBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/edit_coupon")
    private   WebElement  couponSearchBar;
    @AndroidFindBy(id = "app.daalchini.com:id/apply_coupon")
    private WebElement  applyCouponBtn;
    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement  couponsBackBtn;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Payment method set to default']")
    private WebElement pgSelectedConfirmToast;
    @AndroidFindBy(id = "app.daalchini.com:id/item_total_amount")
    private WebElement grandTotalText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='app.daalchini.com:id/textView63']")
    private WebElement emptyCartTxt;
    @AndroidFindBy(id="app.daalchini.com:id/apply_coupon")
    private WebElement couponapplyButton;
    @AndroidFindBy(id="app.daalchini.com:id/remove_coupon")
    private WebElement couponRemoveBtn;
    @AndroidFindBy(id="app.daalchini.com:id/buttonOk")
    private WebElement okBtnCopuponPopuop;
    @AndroidFindBy(id="app.daalchini.com:id/status")
    private WebElement CongratulationText;
     
     
  
    public MyCartPage(AndroidDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public String fetchCheckoutPageHeaderText() {
    	return myCartHeader.getText();
    }
    public void DeleteCart() {
    	clearCart.click();
    }
    public void  AddItemByNavigatingVmScreen() {
    	addItem.clear();
    }
    public MyCartPage ClickMyCartBackBtn() {
    	click(myCartBackbutton);
    	return new MyCartPage(driver);
    }
    public MyCartPage ChangePaymentGateway() {
    	click(pgChangeBtn);
    	return new MyCartPage(driver);
    }
    public MyCartPage OpenCouponList() {
    	click(couponList);
    	return new MyCartPage(driver);
    }
    public String FetchTotalAmount() {
    	return getAttribute(totalAmountText,"text" );    	 
    }
   
    public String FetchGrandTotal() {
    	return grandTotalText.getText();    	 
    }
    public void clickPlaceOrder() {
    	placeOrderBtn.click();
	}
    //inspected coupon name is DCBAT3
    public   MyCartPage EnterCouponName(String couponName) {
    	type(couponSearchBar,couponName);
    	return this;
	}
    public void clickApplycouponBar() {
    	applyCouponBtn.click();
    	
	}
    public void applyCoupon() {
    	couponapplyButton.click();
    }
    public void clickOkCoupnConPopup() {
    	okBtnCopuponPopuop.click();
    }
    public String fecthCongratulationTextfromPopup() {
    	return CongratulationText.getText();
    }
    public MyCartPage navigateToBackFromCouponsScreen() {
    	click(couponsBackBtn);
    	return new MyCartPage(driver);
	}
    public void removeCoupon() {
    	couponRemoveBtn.click();
    }
//    public String  ConfirmSelectedPg() {
//    if (pgSelectedConfirmToast != null) {
//        // Wait for the element to be visible before interacting with it
//     WebElement visibleElement = waitVisibility(pgSelectedConfirmToast);
//     return visibleElement.getAttribute("text");
//    } else {
//     System.err.println("Fetch Deafaul Pg Confirmation Toast element is not initialized.");
//     return null;
//    }
    
   
	//}
    public String GrandTotalTxt() {
		//return getAttribute(grandTotalText,"text" );
    	
    	 // Define the XPath for the Toast message
        String TxtId = "id/items_total";

        // Wait for the Toast message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(TxtId)));

        // Capture the Toast message text
        String grandTotalTxt = driver.findElement(By.xpath(TxtId)).getAttribute("name");
        
        // Print the Toast message
        System.out.println("grand Total Txt: " + grandTotalTxt);
        
        // Return the Toast message
        return grandTotalTxt;

	}
    
   /* public MyCartPage  FetchTheItemCountFromCart() {
    	click(Itemcountfrommycart);
    	return new MyCartPage(driver);
    }*/
    
    public String FetchEmptyCartText() {
		//
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 
		return getAttribute(emptyCartTxt,"text" );
		 
	}
    public String FetchCouponName() {
    	return getAttribute(totalAmountText,"text" );    	 
    }
}
    
