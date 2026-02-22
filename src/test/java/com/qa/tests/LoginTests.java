package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utils.ConfigManager;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
//    private ProductsPage productsPage;
//    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeEachTest() {
        System.out.println("🔹 Starting new test...");

        // Ensure app is always fresh for each test
       // resetApp();

        // Initialize POMs
        loginPage = new LoginPage(driver);
        //homePage = new HomePage(driver);
    }

    @Test(enabled=true)
    public void TC01_TestinvalidOtpLogin() {
          
        loginPage.onboardingscreen();
        loginPage.EnterMob("9958388141");
        loginPage.Continuebutton();
        loginPage.enterOtp("1234");  
        loginPage.SubmitButton();

        System.out.println("🔍 Checking error toast...");
        String actualErrorMessage = loginPage.getInvalidOtpToast();
        String expectedErrorMessage = ConfigManager.get("invalidOtp");

        System.out.println("Actual Error: " + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "❌ OTP error message mismatch!");
    }


    @Test
    public void TC02_TestSuccessfulOtpLogin() {
 
    	resetApp();
        loginPage.EnterMob("9958388141");
        loginPage.Continuebutton();
        loginPage.enterOtp("9958");  
        loginPage.SubmitButton();

          try {
            String actualWelcomeMessage = loginPage.GetWelcomeText();
            String expectedWelcomeMessage = "Hello";

            System.out.println("Actual Welcome Message - " + actualWelcomeMessage);
            Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fetch welcome text");
        }
    }
}
