package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbases.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class LostYourPasswordPage extends WebTestBase {

    @FindBy(xpath = "//a[text()='Lost your password?']")
    WebElement lostYourPwdLink;

    @FindBy(xpath = "//h2[text()='Lost your']")
    WebElement lostPwdPageText;

    @FindBy(xpath = "//input[@value='Reset password']")
    WebElement resetPasswordButton;


    @FindBy(id = "user_login")
    WebElement resetPwdEmailTextBox;
    @FindBy(xpath = "//h2[text()='Thank you']")
        WebElement thankYouTextOfResetPassword;



   public LostYourPasswordPage(){
        PageFactory.initElements(driver, this);
    }
    public void setLogin(String userName ) {
        WebElementUtil.sendKeysOnElement(resetPwdEmailTextBox , userName);

        WebDriverUtil.waitElementUntilClickable(resetPasswordButton);

   }

    public String getTextOfLostPwdPage(){
       return  WebElementUtil.getTextOfElement(lostPwdPageText);
    }
    public void clickOnLostYourPwdLink(){
       WebDriverUtil.waitElementUntilClickable(lostYourPwdLink);
    }


    public String getTextThankYouOfResetPassword(){
        return WebElementUtil.getTextOfElement(thankYouTextOfResetPassword);
    }

}
