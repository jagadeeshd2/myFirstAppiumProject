package com.qa.tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.MyCartPage;
import com.qa.pages.PastOrderPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.VmHomePage;
import com.qa.utils.ConfigManager;

public class HomeTests  extends BaseTest{
	
	 HomePage homePage;
	 VmHomePage vmHomePage;
	 PastOrderPage pastOrderPage;
	 ProfilePage profilePage;
	 MyCartPage myCartPage;
	 String vmName;
	  @BeforeMethod
	    public void setUpPage() {
	        homePage = new HomePage(driver); 
	        vmHomePage = new VmHomePage(driver);
	        pastOrderPage = new PastOrderPage(driver);
	        profilePage = new ProfilePage(driver);
	        myCartPage = new MyCartPage(driver);
	        vmName = ConfigManager.get("vendingMachineName");
// ✅ initialize
	    }
	  @AfterMethod
	  public void relaunchApp() {
		  resetApp();
	  }


	@Test(enabled=true)
	
	public void TC03_SearchVMGlobally()  {
		 
		 homePage.ClickOnGlobalSearchBar();
		 Reporter.log("TC03_SearchVMGlobally");
		  
		 homePage.enterVmName(vmName);
		 homePage.clickVM(vmName);
		 String exp = vmName;
		 String actual = vmHomePage.getVmNameText();
		Assert.assertEquals(actual, exp);
				
	}
	
    @Test(enabled=true)
	
	public void TC04_SearchItemGlobally()  {
		 ClickBackButton();
		 homePage.ClickOnGlobalSearchBar();
		 String requireditemName = ConfigManager.get("itemName");
		 homePage.enterItemName(requireditemName);
		 homePage.selectItem(requireditemName);
		 Reporter.log("Item Globally searched successfully");
		 String exp = requireditemName;
		 String actual = homePage.fetchItemName();
		 Assert.assertEquals(actual, exp);
				
	}

    @Test(enabled=true)
    public void TC05_VerifyCategoriesListPage() {
    	ClickBackButton();
    	homePage.clickOnViewAllCategories();
    	String act = homePage.fetchCategoriesListHeader();
    	String exp = "Categories";
    	Assert.assertEquals(act,exp);
    }
    
    @Test(enabled=true)
    public void TC06_VerifyVMListPage() {
    	 ClickBackButton();
    	 homePage.scrollToViewAllVms();
    	 homePage.clickOnViewAllNearbyVMs();
    	 String act = homePage.fetchVMListHeaderText();
    	 String exp = "Vending Machine";
    	Assert. assertEquals(act,exp);
    }
    @Test(enabled=true)
    public void TC09_VerifyOrdersPage() {
    	// ClickBackButton();
    	 homePage.NavigatetoOrdersScreen();
    	 String act = pastOrderPage.fetchPastOrdersHeader();
    	 String exp = "Orders";
    	 Assert.assertEquals(act,exp);
    }
    @Test(enabled=true)
    public void TC10_VerifyProfilePage() {
    	 //ClickBackButton();
    	 homePage.clickHomeNvBar();
    	 homePage.NavigatetoProfileScreen();
    	 String act = profilePage.FetchProfileScreenHeader();
    	 String exp = "Profile";
    	 Assert.assertEquals(act,exp);
    }
    @Test(enabled=true)
    public void TC11_VerifyCartIcon() {
    	homePage.clickHomeNvBar();
    	homePage.ClickOnGlobalSearchBar();
    	homePage.enterVmName(vmName);
    	homePage.clickVM(vmName);
    	vmHomePage.addFirstAvailableItem();
    	ClickBackButton();
    	ClickBackButton();
    	 homePage.OpenCartFromHomeScreen();
    	 String act = myCartPage.fetchCheckoutPageHeaderText();
    	 String exp = "My Cart";
    	 Assert.assertEquals(act,exp);
    	 myCartPage.DeleteCart();
    }
    @Test(enabled=true)
    public void TC12_VerifyGrandTotal() {
    	//ClickBackButton();
    	homePage.ClickOnGlobalSearchBar();
    	homePage.enterVmName(vmName);
    	homePage.clickVM(vmName);
    	vmHomePage.addFirstAvailableItem();
    	vmHomePage.clickProceedToPay();
    	String amountText = myCartPage.FetchGrandTotal().replaceAll("[^0-9.]", "").trim();
    	Assert.assertTrue(isDouble(amountText), "❌ Amount is not a valid number");
    	 myCartPage.DeleteCart();
    }
}

