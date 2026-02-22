package com.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Debug;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;
import com.qa.utils.ConfigManager;
import com.qa.utils.GestureUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage  {

	
	private final AndroidDriver driver;
    private  final WebDriverWait wait; 
    private GestureUtil gesture;

   
    public HomePage( AndroidDriver driver) {
		 
		 this.driver =driver;
		 this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 this.gesture = new GestureUtil(driver); 
        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(0)),this);
	    }
    
	
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"app.daalchini.com:id/navigation_bar_item_icon_view\").instance(0)")private  WebElement homeNvBar;
			@AndroidFindBy(id = "app.daalchini.com:id/cart_image")private  WebElement cartIconHome;
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"app.daalchini.com:id/navigation_bar_item_icon_view\").instance(2)")private WebElement profileBnbar;
			@AndroidFindBy(id = "app.daalchini.com:id/orders")private WebElement ordersBnbar;
			@AndroidFindBy(id = "app.daalchini.com:id/searchEditText")private WebElement globalSearchBar; 
			@AndroidFindBy(id = "app.daalchini.com:id/titleTextView")
			private List<WebElement> itemList;
			@AndroidFindBy(id = "app.daalchini.com:id/textViewItemName")private WebElement productText;
			@AndroidFindBy(id = "app.daalchini.com:id/view_all_categories")private WebElement viewAllCategories;
			@AndroidFindBy(xpath = "//android.widget.TextView[@text='Categories']")private WebElement categoriesHeader;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text=\"Chocolates & candies\"]")
			private WebElement chocoCandies;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Noodles']")
			private WebElement noodles;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Pasta']")
			private WebElement pasta;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Biscuits & Cookies']")
			private WebElement biscuitsNCookies;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Snacks']")
			private WebElement snacks;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Namkeens']")
			private WebElement namkeens;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Sweets']")
			private WebElement sweets;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Beverage']")
			private WebElement beverage;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Wafers & Chips']")
			private WebElement wafersNChips;
			@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"app.daalchini.com:id/item_name\" and @text='Others']")
			private WebElement others;
			@AndroidFindBy(className = "android.widget.ImageButton")
			private WebElement categoriesBackbtn;
//			@AndroidFindBy(id = "app.daalchini.com:id/view_all_nearby_vm")
//			private WebElement viewAllNearbyVm;
			@AndroidFindBy(id = "app.daalchini.com:id/search")
			private WebElement vmSearchBtn;
			@AndroidFindBy(id = "app.daalchini.com:id/search_src_text")
			private WebElement vmSearchBar;
			@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id='app.daalchini.com:id/company_lis'])[1]/android.view.ViewGroup")
			private WebElement selectVmTestTeam;
//			@AndroidFindBy(id = "app.daalchini.com:id/searchEditText")
//			private WebElement globalEnterField; 
			 private By globalSearchFiel = By.id("app.daalchini.com:id/searchEditText");
			@AndroidFindBy(id = "app.daalchini.com:id/titleTextView")
			private WebElement lassiTheItem;
			@AndroidFindBy(id = "app.daalchini.com:id/add_view_layout")
			private WebElement addButtonGlobal;
			@AndroidFindBy(uiAutomator ="new UiSelector().text(\"Vending Machine\")")
	        private WebElement vmListPageHeader;
			private By viewAllNearbyVmBy = By.id("app.daalchini.com:id/view_all_nearby_vm");
            @AndroidFindBy(id="app.daalchini.com:id/view_all_categories")
            private WebElement viewAllCategoriesbtn;
            @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Categories\")")
            private WebElement categoriesListPageHeader;
		    public void OpenCartFromHomeScreen() {
					wait.until(ExpectedConditions.visibilityOf(cartIconHome));
                	cartIconHome.click();
			}
			public void NavigatetoProfileScreen() {
					wait.until(ExpectedConditions.visibilityOf(profileBnbar));
					profileBnbar.click();
			}
			
			public void NavigatetoOrdersScreen() {
					wait.until(ExpectedConditions.visibilityOf(ordersBnbar));
					ordersBnbar.click();
			      
			}
			
			 public void scrollToGlobalSearchBar() {
				gesture.scrollUntilVisible(globalSearchFiel);
			 }
			public void ClickOnGlobalSearchBar() {
				 wait.until(ExpectedConditions.elementToBeClickable(globalSearchFiel));
				 globalSearchBar.click();
			 }
			public void ViewAllCategories() {
					wait.until(ExpectedConditions.visibilityOf(viewAllCategories));
					viewAllCategories.click();
			}
			public void FetchCategoriesHeaderText() {
					wait.until(ExpectedConditions.visibilityOf(categoriesHeader));

					categoriesHeader.click();
			}
			public void clickHomeNvBar() {
				homeNvBar.click();
			}
			public void clickVM(String vmName) {
				 
				    String xpath = "//android.widget.TextView[@text='"+ vmName + "']";
				    driver.findElement(By.xpath(xpath)).click();
				}

			public void enterVmName(String text) {
				wait.until(ExpectedConditions.visibilityOf(globalSearchBar));
				globalSearchBar.sendKeys(text);
				
			}
			public void enterItemName(String text) {
				wait.until(ExpectedConditions.visibilityOf(globalSearchBar));
				globalSearchBar.sendKeys(text);
				
			}
			public String selectItem(String ItemName) {
				for(WebElement item:itemList) {
					String text = item.getText().trim();
					if(text.equalsIgnoreCase(ItemName)) {
						item.click();
						System.out.println("Clicked item: " + text);
			            return text;
					}
					
				}

			    throw new RuntimeException("Item not found: " + ItemName);
			}
			public String fetchItemName() {
				return productText.getText();
			}
            public void scrollToViewAllVms() {
            	gesture.scrollUntilVisible(viewAllNearbyVmBy);
            	
            }
			 public void clickOnViewAllNearbyVMs() {
			  wait.until(ExpectedConditions.elementToBeClickable(viewAllNearbyVmBy)).click();
			      	
			}
			 public String fetchVMListHeaderText() {
			  		return vmListPageHeader.getText();
			      	
			}
			 public void clickOnViewAllCategories() {
				    viewAllCategoriesbtn.click();
			      	
			}
			 public String fetchCategoriesListHeader() {
			  		
			        return categoriesListPageHeader.getText();
			}
//			 public HomePage SelectBiscuitsNCookies() {
//			  		click(biscuitsNCookies);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectSnacks() {
//			  		click(snacks);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectNamkeens() {
//			  		click(namkeens);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectSweets() {
//			  		click(sweets);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectBeverage() {
//			  		click(beverage);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectWafersNChips() {
//			  		click(wafersNChips);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectDairy() {
//			  		click(dairy);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectMiniMeals() {
//			  		click(miniMeals);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectDryfruitsNutsSeeds() {
//			  		click(dryfruitsNutsSeeds);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectFruitSnacks() {
//			  		click(fruitSnacks);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectGranolaSnackBars() {
//			  		click(granolaSnackBars);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectNonvegSnacks() {
//			  		click(nonvegSnacks);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectPopcorn() {
//			  		click(popcorn);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectPuffedSnacks() {
//			  		click(puffedSnacks);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectCakesBakery() {
//			  		click(cakesBakery);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectMealCombos() {
//			  		click(mealCombos);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage SelectOthers() {
//			  		click(others);
//			      	return new HomePage(driver) ;
//			}
//			 public HomePage NavigateBackFromCategoriesScreen() {
//			  		click(categoriesBackbtn);
//			      	return new HomePage(driver) ; 
//			}
//			 public HomePage OpenAllNearbyVms() {
//				 click(viewAllNearbyVm);
//				 return new HomePage(driver) ;
//			}
//			 public HomePage ClickVmSearchButton( ) {   
//			  		click(vmSearchBtn);
//			      	return new HomePage(driver) ;
//			}
//			public HomePage EnterVmName(String vmName) {
//				   sendKeys(vmSearchBar,vmName);
//			      	return this;
//			}
//			 public HomePage SelectVm( ) {
//				 click(selectVmTestTeam);
//			      	return new HomePage(driver) ;
//			}
//			
//			 public HomePage openGlobalSearchBox( ) {
//				 click(globalSearchBar);
//			      	return new HomePage(driver) ;
//			} 
//			 public HomePage enterItemName(String itemName ) {
//				 sendKeys(globalEnterField, itemName);
//			      	return new HomePage(driver) ; 
//			} 
//			 public HomePage selectItem() {
//				 click(lassiTheItem);
//			      	return new HomePage(driver) ;
//			} 
//			 public HomePage addItemGlobal() {
//				 click(addButtonGlobal);
//			      	return new HomePage(driver) ;
//			} 
}
	

