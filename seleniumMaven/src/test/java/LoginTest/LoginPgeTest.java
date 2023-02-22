package LoginTest;

import basePage.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPgeTest extends TestBase {
    LoginPage loginPage;
    public LoginPgeTest(){
        super();
    }
    @BeforeMethod
    public void Setup(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void titleTest(){
        String title = loginPage.ValidatePageTitle();
        Assert.assertEquals(title,"Sign up for your free TransferMate account");
    }


    @Test
    public void enterDetailsAndSubmit(){
        loginPage.selectEducation();
        loginPage.enterDetails(prop.getProperty("firstName"), prop.getProperty("lastName"),prop.getProperty("emailName"), prop.getProperty("phone"));
        loginPage.selectCheckBoxes();
        loginPage.clickSubmit();
    }
    @Test
    public void enterWrongEmailAndSubmit(){
        loginPage.selectEducation();
        loginPage.enterDetails(prop.getProperty("firstName"), prop.getProperty("lastName"),"xxxxx",prop.getProperty("phone"));
        loginPage.selectCheckBoxes();
        loginPage.clickSubmit();
        loginPage.emailErrorInfo();
    }

    @Test
    public void enterWrongPhoneAndSubmit(){
        loginPage.selectEducation();
        loginPage.enterDetails(prop.getProperty("firstName"), prop.getProperty("lastName"),prop.getProperty("emailName"),"hjjkjk");
        loginPage.selectCheckBoxes();
        loginPage.clickSubmit();
        loginPage.phoneErrorInfo();
    }
    @Test
    public void emptyFieldsInSignUp(){
        loginPage.selectEducation();
        loginPage.enterDetails(" ", " "," "," ");
        loginPage.selectCheckBoxes();
        loginPage.clickSubmit();
        loginPage.emptyFieldsError();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
