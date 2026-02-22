package com.qa.payments;

import com.qa.pages.ActiveordersPage;
import com.qa.pages.MyCartPage;
import com.qa.pages.PaymentPage;
import com.qa.pages.SodexoWebViewPage;
import com.qa.utils.WebViewUtil;
import io.appium.java_client.android.AndroidDriver;

public class SodexoPayment implements Payment {

    private AndroidDriver driver;
    private PaymentPage paymentPage;
    private MyCartPage myCartPage;
    private WebViewUtil webViewUtils;
    private ActiveordersPage activeOrdersPage;
    private SodexoWebViewPage sodexoWebViewPage;

    public SodexoPayment(AndroidDriver driver) {
        this.driver = driver;
        this.paymentPage = new PaymentPage(driver);
        this.myCartPage = new MyCartPage(driver);
        this.webViewUtils = new WebViewUtil(driver);
        this.activeOrdersPage = new ActiveordersPage(driver);
        this.sodexoWebViewPage = new SodexoWebViewPage(driver);
    }

    @Override
    public boolean isAvailable() {
        return paymentPage.isSodexoLinked();
    }

    @Override
    public void pay() {
        paymentPage.selectSodexo();

        if (!isAvailable()) return;

        WebViewUtil.switchToWebView();
        sodexoWebViewPage.enterTestCardPin();
        sodexoWebViewPage.clickPay();
        WebViewUtil.switchToNative();
       
        return activeOrdersPage.waitForOrderSuccess();
    }

    @Override
    public String getName() {
        return "Sodexo";
    }
}
