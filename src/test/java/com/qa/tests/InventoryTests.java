package com.qa.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.MyCartPage;
import com.qa.pages.VmHomePage;
import com.qa.utils.ConfigManager;
import com.qa.utils.Log;
import com.qa.utils.ToastUtils;

public class InventoryTests extends BaseTest {

	             HomePage homePage;
	             VmHomePage vmHomePage;
	             MyCartPage myCartPage;
	             ToastUtils toastUtils;
	             
	             String requireditemName;
	             String vmName;
	             String couponName;
	             
	  @BeforeMethod
	    public void setUpPage() {
	        homePage = new HomePage(driver); 
	        vmHomePage = new VmHomePage(driver);
	        myCartPage = new MyCartPage(driver);
	        toastUtils = new ToastUtils(driver);
       // ✅ initialize
	         requireditemName = ConfigManager.get("itemName");
	         vmName = ConfigManager.get("vendingMachineName");
	         couponName = ConfigManager.get("couponName");
	    }
	  @AfterMethod
	  public void relaunchApp() {
		  resetApp();
	  }


	 @Test(enabled=false)
	 public void TC07_SearchProductInVM() {
		
		 
		 homePage.scrollToGlobalSearchBar();
		 homePage.ClickOnGlobalSearchBar();
		 Log.debug(driver.getPageSource());
		 homePage.enterVmName(vmName);
		 homePage.clickVM(vmName);
		 String item = vmHomePage.searchnFetchProductName(requireditemName);
		 String expectedItem = requireditemName;
	     String   actualItem = item;	 
	     Assert.assertNotNull(actualItem,expectedItem + " was NOT found in the product list!" );
	     Assert.assertEquals(actualItem, expectedItem, "Product name mismatch!");
	     //Assert.assertEquals(actualItem, expectedItem + " was NOT found in the product list!");
	     Reporter.log("item search successful in vm");
	 }

	 @Test(enabled=true)
	 public void TC08_verifyAddToCartFirstAvlItem() {
		 homePage.ClickOnGlobalSearchBar();
		 homePage.enterVmName(vmName);
		 homePage.clickVM(vmName);
		 Assert.assertTrue(vmHomePage.addFirstAvailableItem(),"No item could be added to cart");
		 Log.info("item added tocart successfully");
		 vmHomePage.ClickMinusBtn();
	 }
	 @Test(enabled=true)
	 public void TC09_verifyEmptyCartFirstAvlItem() {
		 
		 homePage.ClickOnGlobalSearchBar();
		 homePage.enterVmName(vmName);
		 homePage.clickVM(vmName);
		 vmHomePage.addFirstAvailableItem();
		 vmHomePage.ClickMinusBtn();
		 Assert.assertTrue(vmHomePage.addFirstAvailableItem(),"Fab is Still visible");
		 Log.info("item removed from cart successfully");
	 }
     @Test(enabled=true)
     public void TC013_verifyApplyCoupon() {
		 homePage.ClickOnGlobalSearchBar();
		 homePage.enterVmName(vmName);
		 homePage.clickVM(vmName);
		 vmHomePage.addFirstAvailableItem();
		 vmHomePage.clickProceedToPay();
		 myCartPage.clickApplycouponBar();
		 myCartPage.EnterCouponName(couponName);
		 myCartPage.applyCoupon();
		 String act = myCartPage.fecthCongratulationTextfromPopup();
		 String exp = "Congratulations!";
		 Assert.assertEquals(act, exp);
		 myCartPage.clickOkCoupnConPopup();
		 myCartPage.removeCoupon();
		 myCartPage.DeleteCart();
     }
     @Test(enabled=true)
     public void TC014_verifyRemoveCoupon() {
    	 
		 homePage.ClickOnGlobalSearchBar();
		 homePage.enterVmName(vmName);
		 homePage.clickVM(vmName);
		 vmHomePage.addFirstAvailableItem();
		 vmHomePage.clickProceedToPay();
		 myCartPage.clickApplycouponBar();
		 myCartPage.EnterCouponName(couponName);
		 myCartPage.applyCoupon();
		 myCartPage.clickOkCoupnConPopup();
		 myCartPage.removeCoupon();
		 String toastText= toastUtils.getLatestToastText(5);
		 Assert.assertTrue(toastText.equalsIgnoreCase("Coupon Removed"));
		// myCartPage.removeCoupon();
		 myCartPage.DeleteCart();
     }

	
	/*@Test(dependsOnMethods = "com.qa.tests.LoginTests.testSuccessfulOtpLogin")
	public String testglobalSearch() throws Exception {
		
		homePage.openGlobalSearchBox();
		homePage.enterItemName("lassi");
		homePage.selectItem();
		homePage.addItemGlobal();
		//Scroll(driver, "down");
		 try {
		        // Try to click the proceedToPayBtn
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(vmHomePage.getProceedToPayBtn()));
		        click(vmHomePage.getProceedToPayBtn());		        
		        myCartPage.DeleteCart();
		        return "Proceeded to pay successfully";
		    } catch (Exception e) {
		        System.out.println("❗ Proceed button not found or not clickable. Checking for toast...");

		        try {
		            // Wait and fetch the toast message
		            WebDriverWait toastWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		            WebElement toastElement = toastWait.until(ExpectedConditions.visibilityOf(itemNotAvailableToast()));
		            return toastElement.getAttribute("text");
		        } catch (Exception ex) {
		            return "❌ Neither proceedToPayBtn nor toast was found.";
		        }}}
	private WebElement itemNotAvailableToast() { */
		
	
	
//	@Test(dependsOnMethods = "com.qa.tests.LoginTests.testSuccessfulOtpLogin")
//	public void TestProductSearch() throws Exception {
//		
//		Scroll(driver, "down");
//		homePage.OpenAllNearbyVms();
//		homePage.ClickVmSearchButton();
//		homePage.EnterVmName("Test Team Data");
//		homePage.SelectVm();
//		vmHomePage.NavigateToItemSearchBar();
//		try {
//			vmHomePage.EnterProductName("Crunchy Namakpara"); 
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//		  
//		try {
//			VmHomePage vmHomePage = new VmHomePage(driver);
//			 String actualTitle =  vmHomePage.FetchItemTitle();
//		String expectedTitle = "Crunchy Namakpara";
//
//		System.out.println("Actual Txt   - " + actualTitle + "\n" + "Expected   Txt - "
//				+ expectedTitle);
//		Assert.assertEquals(actualTitle, expectedTitle);
//		 for (int i = 0; i<4; i++) {
//			 driver.navigate().back();  
//				
//			 }
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
	
	
//	@Test(dependsOnMethods = "TestProductSearch")
//	public void TestAddItemToCart() throws Exception {
//
//		homePage.OpenAllNearbyVms();
//		homePage.ClickVmSearchButton();
//		homePage.EnterVmName("Test Team Data");
//		homePage.SelectVm();
//		vmHomePage.NavigateToItemSearchBar();
//		try {
//			vmHomePage.EnterProductName("Crunchy Namakpara");
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//		if (vmHomePage.isAddButtonEnabled()) {
//			System.out.println("Product is available");
//			vmHomePage.ClickOnAddBtn();
//		} else {
//			System.out.println("Product is not available");
//		}
//		vmHomePage.NavigateToMyCartScreen();
//		 
//		System.out.println("Driver initialized: " + driver);
//		
//		  
//		try {
//			MyCartPage MyCartPage = new MyCartPage(driver);
//			String actualHeaderTxt = MyCartPage.getMycartHeaderText();
//		
//		String expectedHeaderTxt = "My Cart";
//
//		System.out.println("Actual welcome message - " + actualHeaderTxt + "\n" + "Expected welcome message - "
//				+ expectedHeaderTxt);
//		Assert.assertEquals(actualHeaderTxt, expectedHeaderTxt);
//		for (int i = 0; i<5; i++) {
//			 driver.navigate().back();  
//				
//			 }
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//		
//		@Test(dependsOnMethods = "TestAddItemToCart")
//		public void TestClearCart() throws Exception {
//
//			 
//			homePage.OpenCartFromHomeScreen();
//			myCartPage.DeleteCart();
//			System.out.println("Driver initialized: " + driver);
//			
//			  
//			try {
//				MyCartPage myCartPage = new MyCartPage(driver);
//				String actualTxt = myCartPage.FetchEmptyCartText();
//			String expectedTxt = "Your Cart is empty";
//
//			System.out.println("Actual Txt   - " + actualTxt + "\n" + "Expected   Txt - "
//					+ expectedTxt);
//			Assert.assertEquals(actualTxt, expectedTxt);
//			
//			for (int i = 0; i<3; i++) {
//				 driver.navigate().back();  
//					
//				 }
//			
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//		
//		@Test(dependsOnMethods = "TestAddItemToCart")
//		public void TestApplyInvalidCoupon() throws Exception {
//
//			homePage.OpenAllNearbyVms();
//			homePage.ClickVmSearchButton();
//			homePage.EnterVmName("Test Team Data");
//			homePage.SelectVm();
//			vmHomePage.NavigateToItemSearchBar();
//			try {
//				vmHomePage.EnterProductName("Crunchy Namakpara");
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//			if (vmHomePage.isAddButtonEnabled()) {
//				System.out.println("Product is available");
//				vmHomePage.ClickOnAddBtn();
//			} else {
//				System.out.println("Product is not available");
//			}
//			vmHomePage.NavigateToMyCartScreen();
//			myCartPage.ApplyCoupon();
//			//PaymentSettingsPage.SelectDaalchiniPoints();
//			//myCartPage.PlaceYourOrder();
//			System.out.println("Driver initialized: " + driver);
//			
//			  
//			try {
//				ActiveordersPage activeOrdersPage = new ActiveordersPage(driver);
//				String actualHeaderTxt = activeOrdersPage.GetActiveOrdersHeaderText();
//			
//			String expectedHeaderTxt = "Noida Noida Uttar Pradesh";
//
//			System.out.println("Actual welcome message - " + actualHeaderTxt + "\n" + "Expected welcome message - "
//					+ expectedHeaderTxt);
//			Assert.assertEquals(actualHeaderTxt, expectedHeaderTxt);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//		@Test(dependsOnMethods = "TestApplyInvalidCoupon")
//		public void TestApplyValidCoupon() throws Exception {
//
//			homePage.OpenAllNearbyVms();
//			homePage.ClickVmSearchButton();
//			homePage.EnterVmName("Test Team Data");
//			homePage.SelectVm();
//			vmHomePage.NavigateToItemSearchBar();
//			try {
//				vmHomePage.EnterProductName("Crunchy Namakpara");
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//			if (vmHomePage.isAddButtonEnabled()) {
//				System.out.println("Product is available");
//				vmHomePage.ClickOnAddBtn();
//			} else {
//				System.out.println("Product is not available");
//			}
//			vmHomePage.NavigateToMyCartScreen();
//			myCartPage.ApplyCoupon();
//			PaymentSettingsPage.SelectDaalchiniPoints();
//			myCartPage.PlaceYourOrder();
//			System.out.println("Driver initialized: " + driver);
//			
//			  
//			try {
//				ActiveordersPage activeOrdersPage = new ActiveordersPage(driver);
//				String actualHeaderTxt = activeOrdersPage.GetActiveOrdersHeaderText();
//			
//			String expectedHeaderTxt = "Noida Noida Uttar Pradesh";
//
//			System.out.println("Actual welcome message - " + actualHeaderTxt + "\n" + "Expected welcome message - "
//					+ expectedHeaderTxt);
//			Assert.assertEquals(actualHeaderTxt, expectedHeaderTxt);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//		
//		
//		
//		
//		
//		
//		@Test(dependsOnMethods = "TestApplyValidCoupon")
//		public void SuccessfulPaymentsWithDp() throws Exception {
//
//			homePage.OpenAllNearbyVms();
//			homePage.ClickVmSearchButton();
//			homePage.EnterVmName("Test Team Data");
//			homePage.SelectVm();
//			vmHomePage.NavigateToItemSearchBar();
//			try {
//				vmHomePage.EnterProductName("Crunchy Namakpara");
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//			if (vmHomePage.isAddButtonEnabled()) {
//				System.out.println("Product is available");
//				vmHomePage.ClickOnAddBtn();
//			} else {
//				System.out.println("Product is not available");
//			}
//			vmHomePage.NavigateToMyCartScreen();
//			myCartPage.ChangePaymentGateway();
//			PaymentSettingsPage.SelectDaalchiniPoints();
//			myCartPage.PlaceYourOrder();
//			System.out.println("Driver initialized: " + driver);
//			
//			  
//			try {
//				ActiveordersPage activeOrdersPage = new ActiveordersPage(driver);
//				String actualHeaderTxt = activeOrdersPage.GetActiveOrdersHeaderText();
//			
//			String expectedHeaderTxt = "Noida Noida Uttar Pradesh";
//
//			System.out.println("Actual welcome message - " + actualHeaderTxt + "\n" + "Expected welcome message - "
//					+ expectedHeaderTxt);
//			Assert.assertEquals(actualHeaderTxt, expectedHeaderTxt);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    }
//		
//		@Test(dependsOnMethods = "TestClearCart")
//		public void TestCategorySelection() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestCategorySelection")
//		public void TestVmSelection() throws Exception {
//			
//		}
//			
//		@Test(dependsOnMethods = "TestVmSelection")
//		public void TestGridview() throws Exception {
//			
//			
//	    }
//		@Test(dependsOnMethods = "TestGridview")
//		public void TestSortingTopToBottom () throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestSortingTopToBottom")
//		public void TestBottomToTopFilter() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestSortingTopToBottom")
//		public void  TestSortingHighToLow() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestSortingHighToLow")
//		public void  TestSortingLowToHigh() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestSortingLowToHigh")
//		public void  TestUserNameUpdate() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestUserNameUpdate")
//		public void  TestUserEmailUpdate() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestUserEmailUpdate")
//		public void  TestGenderSelection() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestGenderSelection")
//		public void   TestDefaultPg() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestDefaultPg")
//		public void   TestDpBalanceFetching() throws Exception {
//			
//		}
//		
//		@Test(dependsOnMethods = "TestDpBalanceFetching")
//		public void   TestBpBalanceFetching() throws Exception {
//			
//		}
		
		
		
		
}

/*
 * @Test public void testAddButtonFunctionality() { // Check if the Add button
 * is enabled if (VmHomePage.isAddButtonEnabled()) {
 * System.out.println("Add button is enabled"); } else {
 * System.out.println("Add button is disabled"); } }
 * 
 * @Test public void testScrolling() { // Perform vertical scroll
 * scrollingUtil.scrollVertically();
 * 
 * // Perform horizontal scroll scrollingUtil.scrollHorizontally(); } }
 */
