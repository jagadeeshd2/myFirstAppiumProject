package com.qa.payments;

import com.qa.pages.ActiveordersPage;
import com.qa.pages.MyCartPage;
import com.qa.pages.PaymentPage;
import com.qa.utils.ToastUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class CorporateBusinessWalletPayment implements Payment {

    private PaymentPage paymentPage;
    private ActiveordersPage activeOrdersPage;
    private MyCartPage myCartPage;
    private AndroidDriver driver;

    public CorporateBusinessWalletPayment(AndroidDriver driver) {
        this.driver = driver;
        this.paymentPage = new PaymentPage(driver);
        this.activeOrdersPage = new ActiveordersPage(driver);
        this.myCartPage = new MyCartPage(driver);
    }

    @Override
    public boolean isAvailable() {
        return paymentPage.isCorporateWalletLinked();
    }

    @Override
    public void pay() {
        paymentPage.selectCorporateWallet();
        activeOrdersPage.confirmPayment();
    }

    @Override
    public String getName() {
        return "Corporate Wallet";
    }
}
