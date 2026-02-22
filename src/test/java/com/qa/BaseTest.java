package com.qa;

import java.net.URL;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.qa.utils.ConfigManager;
import com.qa.utils.Log;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    protected static AndroidDriver driver;   // <--- STATIC so it is shared
    protected static UiAutomator2Options options;

    // =========================================================
    //  SUITE SETUP (RUNS ONCE)
    // =========================================================
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {

        System.out.println("⏳ Initializing Test Suite...");
        ConfigManager.loadConfig();
        
        Log.info("🚀 Framework initialization started...");
       
        Log.info("✔ Config loaded successfully.");

  
        System.out.println("DEBUG → platformName = " + ConfigManager.get("platformName"));


        try {
            // Load values from config.properties
            String platformName = ConfigManager.get("platformName");
            String platformVersion = ConfigManager.get("platformVersion");
            String deviceName = ConfigManager.get("deviceName");
            String androidAppPackage = ConfigManager.get("androidAppPackage");
            String androidAppActivity = ConfigManager.get("androidAppActivity");
            String automationName = ConfigManager.get("automationName");

            options = new UiAutomator2Options();
            options.setPlatformName(platformName);
            options.setPlatformVersion(platformVersion);
            options.setDeviceName(deviceName);
            options.setAutomationName(automationName);

            options.setAppPackage(androidAppPackage);
            options.setAppActivity(androidAppActivity);

            options.setAutoGrantPermissions(true);
            options.setNoReset(false);
            options.setCapability("appium:elementWaitTimeout", 10000);

            // Start driver once for whole suite
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("✅ Driver launched successfully – Session: " + driver.getSessionId());
            // after driver starts:
            Log.info("✔ Appium driver launched. Session ID: " + driver.getSessionId());
            // Init Appium driver code here...
           // ExtentTestNGListener.getTest().info("Driver Started");
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize driver: " + e.getMessage());
            throw e;
        }
    }

    // =========================================================
    //  SUITE TEARDOWN (RUNS ONCE)
    // =========================================================
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
            System.out.println("🚫 Driver terminated after test suite.");
            //ExtentTestNGListener.getTest().info("Driver Closed");
        }
    }
    
   

    // =========================================================
    //  BASIC DRIVER ACTIONS
    // =========================================================
    public void click(Object element) {
        ((WebElement) element).click();
    }

    public void type(WebElement element,String text) {
    	element.clear();
    	element.sendKeys(text);
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getAttribute(WebElement element, String attr) {
        return element.getAttribute(attr);
    }
    public void ClickBackButton() {
    	driver.navigate().back();
    }
    public WebElement scrollUsingUiScrollable(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + text + "\")"));
    }
    public boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void acceptConfirPopup() {
    	driver.switchTo().alert().accept();
    }

    // =========================================================
    //  APP CONTROL
    // =========================================================
    public void terminateApp() {
        driver.executeScript("mobile: terminateApp", Map.of("appId", "app.daalchini.com"));
    }

    public void launchApp() {
        driver.executeScript("mobile: activateApp", Map.of("appId", "app.daalchini.com"));
    }

    public void resetApp() {
        terminateApp();
        launchApp();
    }
}
