package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbases.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class LoginPage extends WebTestBase {
    @FindBy(id="username")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;
    @FindBy(name = "login")
    WebElement loginBtn;
    @FindBy(xpath = "//strong[text()='ERROR']")
    WebElement errorMessage;

    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement usernameRequiredErrorMessage;
    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement passwordRequiredErrorMessage;



   public LoginPage(){
        //to initialize webelemnt we have to use pagefactory class .initElements method
        PageFactory.initElements(driver, this);
    }
    public void setLogin(String userName , String password){
        WebElementUtil.sendKeysOnElement(userNameTextBox , userName);
        WebElementUtil.sendKeysOnElement(passwordTextBox, password);
        WebDriverUtil.waitElementUntilClickable(loginBtn);
    }
    public String getTextOfErrorMessage(){
      return WebElementUtil.getTextOfElement(errorMessage);
    }
    public String getTextOfUsernameRequiredErrorMessage(){
       return WebElementUtil.getTextOfElement(usernameRequiredErrorMessage);
    }
    public String getTextOfPasswordRequiredErrorMessage(){
        return WebElementUtil.getTextOfElement(passwordRequiredErrorMessage);
    }
    public void clickOnLoginBtn(){
       WebDriverUtil.waitElementUntilClickable(loginBtn);
    }

}
