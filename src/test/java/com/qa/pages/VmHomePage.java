package com.qa.pages;

 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;
import com.qa.utils.GestureUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VmHomePage  extends  BaseTest{
	private AndroidDriver driver;
    private  WebDriverWait wait;
    private GestureUtil gesture;
    
    
    @AndroidFindBy( xpath = "(//android.widget.TextView[@resource-id='app.daalchini.com:id/quantity'])[1]")//(//android.widget.TextView[@resource-id="app.daalchini.com:id/quantity"])[1]
    private WebElement addButton;
    @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"VM8\")")
    private WebElement vmName;
    @AndroidFindBy(id = "app.daalchini.com:id/vm_view")
    private WebElement vmViewBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/cart_image")
    private WebElement cartIcon;
    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement vmHomeBackbutton;
    @AndroidFindBy(id = "app.daalchini.com:id/plus")
    private WebElement itemPlusButton;
    @AndroidFindBy(id = "app.daalchini.com:id/minus")
    private WebElement itemMinusButton;   
    @AndroidFindBy(id = "app.daalchini.com:id/search_icon")
    private WebElement itemSearchBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/search_src_text")
    private WebElement productSearchBar;
    @AndroidFindBy(id = "app.daalchini.com:id/search_cancel_button")
    private WebElement cancelSearch;
    @AndroidFindBy(id = "app.daalchini.com:id/proceed_to_pay")
    private WebElement proceedToPayBtn; 
    @AndroidFindBy(id = "app.daalchini.com:id/product_name")
    private WebElement productName; 
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"app.daalchini.com:id/checkout_bar\")")
    private WebElement fabIcon;
    @AndroidFindBy(id = "app.daalchini.com:id/cancel_button")
    private WebElement FabIconCrossBtn;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='app.daalchini.com:id/product_name'])[1]")
    private WebElement itemTitle; 
    @AndroidFindBy(xpath = "(//android.widget.Toast[@text=\"Daalchini\"]")
    private WebElement itemNotAvailableToast;
    @AndroidFindBy(id = "app.daalchini.com:id/product_name")
	private List<WebElement>  productNameList;
    @AndroidFindBy(id = "app.daalchini.com:id/quantity")
    private List<WebElement> addBtnList;
    public VmHomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.gesture = new GestureUtil(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
 // Method to check if the Add button is enabled
    public boolean isAddButtonEnabled() {
        return addButton.isEnabled();
    }
    public MyCartPage ClickOnAddBtn() {
    	click(addButton);
    	return new MyCartPage(driver);
    }
    
    public String getVmNameText() {
        WebElement elem = wait.until(ExpectedConditions.visibilityOf(vmName));
        return elem.getText();
    }
    
    public VmHomePage NavigateToVmView() {
    	click(vmViewBtn);
    	return new VmHomePage(driver);
    }
    public VmHomePage SelectCartIcon() {
    	click(cartIcon);
    	return new VmHomePage(driver); 
    }
    public VmHomePage ClickVmBackBtn() {
    	click(vmHomeBackbutton);
    	return new VmHomePage(driver);
    }
    public VmHomePage ClickPlusBtn() {
    	click(itemPlusButton);
    	return new VmHomePage(driver);
    }
    public VmHomePage ClickMinusBtn() {
    	click(itemMinusButton);
    	return new VmHomePage(driver);
    }
    public VmHomePage NavigateToItemSearchBar() {
    	click(itemSearchBtn);
    	return new VmHomePage(driver);
    }
    public VmHomePage EnterProductName(String ProductName) {
    	type(productSearchBar,ProductName);
    	 
    	return this;
    }
    public VmHomePage CancelProductSearch() {
    	click(cancelSearch);
    	return new VmHomePage(driver);
    }
    public VmHomePage NavigateToMyCartScreen() {
    	click(getProceedToPayBtn());
    	return new VmHomePage(driver);
    }
    public VmHomePage CloseProductFabIcon() {
    	click(FabIconCrossBtn);
    	return new VmHomePage(driver);
    }
    public String FetchItemTitle() {
		
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 
		return getAttribute(itemTitle,"text" ); }
		 
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		 
//		return getAttribute(itemNotAvailableToast,"text" );
		
    public String fetchItemUnavialableToast() {
		return new WebDriverWait(driver, Duration.ofSeconds(20))
	             .until(ExpectedConditions.visibilityOf(itemNotAvailableToast))
	             .getAttribute("text");

    }

	public void clickProceedToPay() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(proceedToPayBtn));
			proceedToPayBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	public void setProceedToPayBtn(WebElement proceedToPayBtn) {
		this.proceedToPayBtn = proceedToPayBtn;
	}
//	public void browseProducts() {
//		for(WebElement item : productList) {
//			 //String product =plist.getText().trim();
//			 if(item.equalsIgnoreCase(productName));
//			  scrollUsingUiScrollable(item);
//		}
	public String searchnFetchProductName(String itemName) {
		itemSearchBtn.click();
		type(productSearchBar, itemName);
		for(WebElement item : productNameList) {
			 String name =item.getText().trim();
			 if(name.equalsIgnoreCase(itemName)) {
				 System.out.println("Product search successful");
				 return name; 
			 }
    }
		return null;
	}
		public boolean isFabVisible() {
			 try {
			        return fabIcon.isDisplayed();
			    } catch (Exception e) {
			        return false;
			    }
    }
	public boolean addFirstAvailableItem( ) {
		for(WebElement addBtn : addBtnList) {
			try {
				if( !addBtn.isEnabled()) {
				   continue;
                     }else if (!addBtn.isDisplayed()) {
                    	 gesture.scrollUntilVisibleWE(addBtn);
                     }
				wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
			   if(isFabVisible()) {
				   
				   return true; // stop after first successful add
	            }
			}catch(Exception e){
				System.out.println("⚠️ Add failed, trying next item...");
	            continue; // move to next item
			}
		   }
		 return false; // no item could be added
     }
	
	
}
