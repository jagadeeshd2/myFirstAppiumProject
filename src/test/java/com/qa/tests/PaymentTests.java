package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.ActiveordersPage;
import com.qa.pages.HomePage;
import com.qa.pages.MyCartPage;
import com.qa.pages.PastOrderPage;
import com.qa.pages.PaymentPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.VmHomePage;
import com.qa.payments.Payment;
import com.qa.payments.PaymentFactory;
import com.qa.utils.ConfigManager;

public class PaymentTests extends BaseTest{


	 HomePage homePage;
	 VmHomePage vmHomePage;
	 PastOrderPage pastOrderPage;
	 ProfilePage profilePage;
	 MyCartPage myCartPage;
	 PaymentPage paymentPage;
	 ActiveordersPage activeOrdersPage;
	 String vmName;
	  @BeforeMethod
	    public void setUpPage() {
	        homePage = new HomePage(driver); 
	        vmHomePage = new VmHomePage(driver);
	        pastOrderPage = new PastOrderPage(driver);
	        profilePage = new ProfilePage(driver);
	        myCartPage = new MyCartPage(driver);
	        paymentPage =new PaymentPage(driver);
	        activeOrdersPage = new ActiveordersPage(driver);
	        vmName = ConfigManager.get("vendingMachineName");
	  }
	

	  @AfterMethod
	  public void relaunchApp() {
		  resetApp();
	  }

	  @Test
	  public void TC16_verifyPaymentViaDaalchiniWallet() {
		
		  homePage.ClickOnGlobalSearchBar();
		  homePage.enterVmName(vmName);
		  homePage.enterVmName(vmName);
		  homePage.clickVM(vmName);
		  vmHomePage.addFirstAvailableItem();
		  
//		  myCartPage.ChangePaymentGateway();
//		  paymentPage.selectDaalchiniWallet();
//		  myCartPage.clickPlaceOrder();
		  
		  if(vmHomePage.isFabVisible()) {
			  vmHomePage.clickProceedToPay();
		  Payment payment = PaymentFactory.get("wallet", driver);
		  payment.pay(); 
		  Assert.assertTrue(
			        activeOrdersPage.isOrderCreated(),
			        "❌ Order not created after wallet payment");
	  
		  }
	  }}
	
