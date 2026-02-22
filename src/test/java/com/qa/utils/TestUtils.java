package com.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
  
	 public static final int WAIT = 15;

	    public static String getTimestamp() {
	        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    }

	    public static void sleep(long millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
}
