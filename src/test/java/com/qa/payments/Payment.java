package com.qa.payments;

public interface Payment {

    boolean isAvailable();

    void pay();

    String getName();
}
