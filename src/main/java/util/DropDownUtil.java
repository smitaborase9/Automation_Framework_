package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbases.WebTestBase;

public class DropDownUtil extends WebTestBase {
    public static Select select;

    public static void dropdownElement(int index , WebElement element){
        select =new Select(element);
        select.selectByIndex(index);
    }
    public static void dropDownElement(String visibletext , WebElement element){
        select=new Select(element);
        select.selectByVisibleText(visibletext);
    }
    public static void dropDownByValue(String value , WebElement element){
        select=new Select(element);
        select.selectByValue(value);
    }
    public static void dropDownVisibleText( String visibleWithText , WebElement element){
        select=new Select(element);
        select.deselectByVisibleText(visibleWithText);
    }
}
