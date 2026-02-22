package com.qa.payments;

import com.qa.pages.MyCartPage;
import com.qa.pages.PaymentPage;
import com.qa.utils.WebViewUtil;
import io.appium.java_client.android.AndroidDriver;

public class RazorpayPayment implements Payment {

    private AndroidDriver driver;
    private PaymentPage paymentPage;
    private RazorPayWebViewPage razorPayWebViewPage;
    private MyCartPage myCartPage;
    private WebViewUtil webViewUtil;
    public RazorpayPayment(AndroidDriver driver) {
        this.driver = driver;
        this.paymentPage = new PaymentPage(driver);
        this.razorPayWebViewPage = new RazorPayWebViewPage(driver);
        this.myCartPage = new MyCartPage(driver);
    }

    @Override
    public boolean isAvailable() {
        return paymentPage.isRazorpayAvailable();
    }

    @Override
    public void pay() {
        paymentPage.selectRazorpay();
        webViewUtil.switchToWebView();
        razorPayWebViewPage.completePayment();
        webViewUtil.switchToNative();
  
    }

    @Override
    public String getName() {
        return "Razorpay";
    }
}
