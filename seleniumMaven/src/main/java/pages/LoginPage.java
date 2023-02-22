package pages;

import basePage.TestBase;
import jdk.jfr.Name;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(css="#register_account_type_education_form_input > label")
    WebElement eductionRadioButton;
    @FindBy(name="first_name")
    WebElement firstName;
    @FindBy(name="last_name")
    WebElement lastName;
    @FindBy(name="email")
    WebElement emailName;
    @FindBy(name="__pin_mobile_number_mobile_phone")
    WebElement phoneNumber;
    @FindBy(css = "#register_terms_of_use_agree_form_input > label")
    WebElement termsCheckbox;
    @FindBy(css="#register_newsletter_and_privacy_policy_agree_form_input > label")
    WebElement newsletterCheckbox;
    @FindBy(name="button_subscribe")
    WebElement subscribeButton;

    @FindBy(css="#register_email_error")
    WebElement emailError;

    @FindBy(css="#register___pin_mobile_number_mobile_phone_error")
    WebElement phoneNumberError;

    @FindBy(css="#register_first_name_error")
    WebElement emptyFieldError;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public  String ValidatePageTitle(){
        return driver.getTitle();
    }
    public void selectEducation(){
        eductionRadioButton.click();
    }
    public void enterDetails(String fn,String ln, String email, String ph ){
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        emailName.sendKeys(email);
        phoneNumber.sendKeys(ph);
    }

    public void selectCheckBoxes(){
        phoneNumber.sendKeys(Keys.PAGE_DOWN);
        termsCheckbox.click();
        phoneNumber.sendKeys(Keys.PAGE_DOWN);
        newsletterCheckbox.click();

    }

    public void clickSubmit(){
        subscribeButton.click();
    }

    public void emailErrorInfo(){
        emailError.isDisplayed();
    }
    public void phoneErrorInfo(){
        phoneNumberError.isDisplayed();
    }

    public void emptyFieldsError() {
        emptyFieldError.isDisplayed();
    }
}
