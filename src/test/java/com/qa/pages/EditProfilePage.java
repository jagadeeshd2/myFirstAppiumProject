package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditProfilePage extends BaseTest{


	private AppiumDriver driver;
    private static WebDriverWait wait;
    
    
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")private WebElement profileEditBackBtn;
    @AndroidFindBy(id = "app.daalchini.com:id/name")private WebElement profileNameinEditProfile;
    @AndroidFindBy(id = "app.daalchini.com:id/entername")private WebElement fullNameTxtFld;
    @AndroidFindBy(id = "app.daalchini.com:id/textView")private WebElement genderDropDown;
    @AndroidFindBy(id = "//android.widget.TextView[@resource-id='app.daalchini.com:id/textView' and @text='male']")private WebElement genderMaleDd;
    @AndroidFindBy(id = "//android.widget.TextView[@resource-id='app.daalchini.com:id/textView' and @text='female']")private WebElement genderFemaleDd;
    @AndroidFindBy(id = "app.daalchini.com:id/enterEmail")private WebElement emailIdTxtFld;
    @AndroidFindBy(id = "app.daalchini.com:id/enterPhone")private WebElement profileMobTxtFld;
    @AndroidFindBy(id = "app.daalchini.com:id/update_profile")private WebElement profileUpdate;
    
    
    public EditProfilePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    
    public EditProfilePage ClickEditProfileBackButton() {
  		click(profileEditBackBtn);
      	return this;
      }
      
 
public String ViewProfileNameInEditprofile() {
		
	 if (profileNameinEditProfile != null) {
		 WebElement visibleElement = waitVisibility(profileNameinEditProfile);
		 return visibleElement.getAttribute("text");
	 }else {
		 System.err.println("profile Update Confirmation Text element is not initialized.");
         return null;
	 }
}


public EditProfilePage EnterFullName(String usersFullname) {
		sendKeys(profileEditBackBtn, usersFullname);
  	return this;
  }


public EditProfilePage ClickGenderDrodown() {
		click(genderDropDown);
  	return this;
  }

public EditProfilePage SelectMaleGender() {
	click(genderMaleDd);
	return this;
}

public EditProfilePage SelectFemaleGender() {
	click(genderFemaleDd);
	return this;
}

public EditProfilePage EnterEmail(String emailId) {
	sendKeys(emailIdTxtFld, emailId);
	return this;
}


public EditProfilePage EnterMob(String mobEnter) {
	sendKeys(profileMobTxtFld, mobEnter);
	return this;
}

public EditProfilePage ClickUpdateProfile() {
	click(profileUpdate);
	return this;
}

}
		 
    

