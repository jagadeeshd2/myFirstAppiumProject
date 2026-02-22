package com.qa.payments;

import io.appium.java_client.android.AndroidDriver;

public class PaymentFactory {

    public static Payment get(String type, AndroidDriver driver) {

        switch (type.toLowerCase()) {
            case "wallet":
                return new DaalchiniWalletPayment(driver);
            case "corporate":
                return new CorporateBusinessWalletPayment(driver);
            case "sodexo":
                return new SodexoPayment(driver);
            case "razorpay":
                return new RazorpayPayment(driver);
            default:
                throw new RuntimeException("Invalid payment type: " + type);
        }
    }
}
