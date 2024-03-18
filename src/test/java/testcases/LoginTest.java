package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbases.WebTestBase;

public class LoginTest extends WebTestBase {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    LoginTest(){
        super();
    }
    @BeforeMethod()
    public void preRequisite(){
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        myAccountPage=new MyAccountPage();

    }
    @Test(description = "Verify login with valid username and valid password")
    public void verifyLoginWithValidUserNameAndPassword(){
        SoftAssert softAssert= new SoftAssert();
    homePage.closeFirstAd();
    homePage.clickOnLoginAndregister();
    loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("password"));
    softAssert.assertEquals(myAccountPage.getMyAccountElement(), "MY ACCOUNT" , "MY ACCOUNT TEXT SHOULD BE MATCHED");
    softAssert.assertAll();
    }
    @Test(description = "Verify login with invalid username and valid password")
    public void verifyLoginWithInvalidUserNameAndPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndregister();
        loginPage.setLogin(prop.getProperty("invalidUsername"), prop.getProperty("password"));

        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR" , "error message should be display");
        softAssert.assertAll();
    }
    @Test(description = "Verify login with valid username and invalid password")
    public void verifyLoginWithValidUserNameAndInvalidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndregister();
        loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("invalidPassword"));

        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR" , "error message should be display");
        softAssert.assertAll();
    }
    @Test(description = "Verify login with invalid username and invalid password")
    public void verifyLoginWithInValidUserNameAndInvalidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndregister();
        loginPage.setLogin(prop.getProperty("invalidUsername"), prop.getProperty("invalidPassword"));

        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR" , "error message should be display");
        softAssert.assertAll();
    }
    @Test(description = "Verify login without  username and invalid password")
    public void verifyLoginWithoutUserNameAndInvalidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndregister();
        loginPage.setLogin(prop.getProperty("withoutUsername"), prop.getProperty("invalidPassword"));

        softAssert.assertEquals(loginPage.getTextOfUsernameRequiredErrorMessage(), "Error:" , "username required message should be display");
        softAssert.assertAll();
    }
    @Test(description = "Verify login without  username and valid password")
    public void verifyLoginWithoutUserNameAndValidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndregister();
        loginPage.setLogin(prop.getProperty("withoutUsername"), prop.getProperty("password"));

        softAssert.assertEquals(loginPage.getTextOfUsernameRequiredErrorMessage(), "Error:" , "username required message should be display");
        softAssert.assertAll();
    }
    @Test(description = "Verify login without  username and valid password")
    public void verifyLoginWithValidUserNameAndWithoutPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndregister();
        loginPage.setLogin(prop.getProperty("withoutUsername"), prop.getProperty("withoutPassword"));

        softAssert.assertEquals(loginPage.getTextOfPasswordRequiredErrorMessage(), "Error:" , " The password field is empty message should be display");
        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
