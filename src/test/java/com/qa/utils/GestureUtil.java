package com.qa.utils;



import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class GestureUtil {
	
	 private AppiumDriver driver;

	    public GestureUtil(AppiumDriver driver) {
	        this.driver = driver;
	    }

	    public WebElement scrollToElement(WebElement viewAllNearbyVm) {
		    return driver.findElement(
		        AppiumBy.androidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true))"
		            + ".scrollIntoView(new UiSelector().text(\"" + viewAllNearbyVm + "\"))"
		        )
		    );
		}
	
	    private void performSwipe(int startX, int startY, int endX, int endY) {
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1);
	        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Collections.singletonList(swipe));
	    }
	  
	    public void swipeUp() {
	        Dimension size = driver.manage().window().getSize();
	        int startX = size.getWidth() / 2;
	        int startY = (int) (size.getHeight() * 0.8);
	        int endY = (int) (size.getHeight() * 0.2);
	        performSwipe(startX, startY, startX, endY);
	    }
	    public void swipeDown() {
	        Dimension size = driver.manage().window().getSize();
	        int startX = size.getWidth() / 2;
	        int startY = (int) (size.getHeight() * 0.2);
	        int endY = (int) (size.getHeight() * 0.8);
	        performSwipe(startX, startY, startX, endY);
	    }
	  
	    public void swipeLeft() {
	        Dimension size = driver.manage().window().getSize();
	        int startY = size.getHeight() / 2;
	        int startX = (int) (size.getWidth() * 0.9);
	        int endX = (int) (size.getWidth() * 0.1);
	        performSwipe(startX, startY, endX, startY);
	    }
	   
	    public void swipeRight() {
	        Dimension size = driver.manage().window().getSize();
	        int startY = size.getHeight() / 2;
	        int startX = (int) (size.getWidth() * 0.1);
	        int endX = (int) (size.getWidth() * 0.9);
	        performSwipe(startX, startY, endX, startY);
	    }
	   
	    public WebElement scrollToText(String visibleText) {
	        return driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
	    }
//	    public WebElement scrollToElement(String visibleText) {
//	        return driver.findElement(AppiumBy.androidUIAutomator(
//	            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
//	    }
	    public void scrollUntilVisibleWE(WebElement element) {
	        int maxScrolls = 7;
	        // 1️⃣ Scroll UP first (most common case)
	        for (int i = 0; i < maxScrolls; i++) {
	            try {
	                if (element.isDisplayed()) {
	                    return; // element is visible
	                }
	            } catch (Exception e) {
	                // element not visible yet
	            }
	            swipeUp();
	        }
	        // 2️⃣ If not found → scroll DOWN
	        for (int i = 0; i < maxScrolls; i++) {
	            try {
	                if (element.isDisplayed()) {
	                    return;
	                }
	            } catch (Exception e) {
	                // keep scrolling
	            }
	            swipeDown();
	        }
	        throw new RuntimeException(
	            "Element not visible after scrolling up and down"
	        );
	    }

	    public void scrollUntilVisible(By locator) {
	        int maxScrolls = 7;
	        // 1️⃣ Try scrolling UP first
	        for (int i = 0; i < maxScrolls; i++) {
	            if (driver.findElements(locator).size() > 0) {
	                return;   // element is now visible
	            }
	            swipeUp();   // primary scroll direction
	        }
	        // 2️⃣ If still not found → scroll DOWN (reverse)
	        for (int i = 0; i < maxScrolls; i++) {
	            if (driver.findElements(locator).size() > 0) {
	                return;   // found during reverse scroll
	            }
	            swipeDown();  // reverse direction
	        }
	        throw new RuntimeException("❌ Element NOT found after UP + DOWN scrolls → " + locator);
	    }

	    public void scrollUntilVisible(By locator, String direction) {
	        for (int i = 0; i < 7; i++) {
	            if (driver.findElements(locator).size() > 0) {
	                return;  // element is visible in DOM
	            }
	            if (direction.equalsIgnoreCase("up")) {
	                swipeUp();
	            } else if (direction.equalsIgnoreCase("down")) {
	                swipeDown();
	            } else {
	                throw new IllegalArgumentException("Invalid direction: " + direction);
	            }
	        }
	        throw new RuntimeException("Element not found after scrolling " + direction + ": " + locator);
	    }
	   
	    public void tapOnElement(WebElement element) {
	        int centerX = element.getRect().x + (element.getRect().width / 2);
	        int centerY = element.getRect().y + (element.getRect().height / 2);
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence tap = new Sequence(finger, 1);
	        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
	        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Collections.singletonList(tap));
	    }
	  
	    public void longPress(WebElement element, Duration holdDuration) {
	        int centerX = element.getRect().x + (element.getRect().width / 2);
	        int centerY = element.getRect().y + (element.getRect().height / 2);
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence longPress = new Sequence(finger, 1);
	        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
	        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        longPress.addAction(new org.openqa.selenium.interactions.Pause(finger, holdDuration));
	        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Collections.singletonList(longPress));
	    }

	    // ------------------------------
	    // UIAutomator Scroll (FASTEST)
	    // ------------------------------
	    public WebElement scrollUsingUiScrollable(String text) {
	        return driver.findElement(AppiumBy.androidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + text + "\")"));
	    }



}
