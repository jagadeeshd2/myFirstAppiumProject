package com.qa.utils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.netty.handler.timeout.TimeoutException;

public class ToastUtils {
	
	 private AndroidDriver driver;

	    // Toast locator (Android standard)
	    private static final By TOAST_LOCATOR =
	            AppiumBy.xpath("//android.widget.Toast");

	    public ToastUtils(AndroidDriver driver) {
	        this.driver = driver;
	    }

	    /**
	     * Fetch latest visible toast text
	     */
	    public String getLatestToastText(int timeoutInSeconds) {

	    	  try {
	              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	              WebElement toast = wait.until(
	                  ExpectedConditions.presenceOfElementLocated(
	                      By.xpath("//android.widget.Toast")
	                  )
	              );

	              return toast.getText();

	          } catch (TimeoutException e) {
	              return null; // no toast appeared
	          } catch (StaleElementReferenceException e) {
	              // Retry once more (toast may have refreshed)
	              try {
	                  return driver.findElement(By.xpath("//android.widget.Toast")).getText();
	              } catch (Exception ex) {
	                  return null;
	              }
	          }
	      }
	    /**
	     * Fetch ALL toast texts appeared within timeout
	     */
	    public List<String> getAllToasts(int timeoutInSeconds) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(d -> driver.findElements(TOAST_LOCATOR).size() > 0);

	        return driver.findElements(TOAST_LOCATOR)
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

}
