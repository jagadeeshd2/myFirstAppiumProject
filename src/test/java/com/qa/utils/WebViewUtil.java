package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebViewUtil {

    private AndroidDriver driver;

    public WebViewUtil(AndroidDriver driver) {
        this.driver = driver;
    }

    public void switchToWebView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(d -> driver.getContextHandles().size() > 1);

        for (String context : driver.getContextHandles()) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                return;
            }
        }

        throw new RuntimeException("❌ WebView context not found");
    }

    public void switchToNative() {
        driver.context("NATIVE_APP");
    }
}
