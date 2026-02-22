package com.qa.payments;

import com.qa.pages.ActiveordersPage;
import com.qa.pages.MyCartPage;
import com.qa.pages.PaymentPage;
import io.appium.java_client.android.AndroidDriver;

public class DaalchiniWalletPayment implements Payment {

    private PaymentPage paymentPage;
    private ActiveordersPage activeOrdersPage;
    private MyCartPage myCartPage;

    public DaalchiniWalletPayment(AndroidDriver driver) {
        this.paymentPage = new PaymentPage(driver);
        this.activeOrdersPage = new ActiveordersPage(driver);
        this.myCartPage = new MyCartPage(driver);
    }

    @Override
    public boolean isAvailable() {
        return paymentPage.isDaalchiniWalletAvailable();
    }

    @Override
    public void pay() {
    	myCartPage.ChangePaymentGateway();
        paymentPage.selectDaalchiniWallet();
        myCartPage.clickPlaceOrder();
        //activeOrdersPage.confirmPayment();
    }

    @Override
    public String getName() {
        return "Daalchini Wallet";
    }
}
