package testbases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.WebDriverUtil;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
public Properties prop;
public static WebDriver driver;
    FileInputStream fileInputStream = null;
     public WebTestBase(){

        try{
             fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/properties/config.properties");
        }catch (Exception e){
            e.printStackTrace();
        }
         prop= new Properties();
        try {
            prop.load(fileInputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initialization(){
        String browserName=prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/browsers/chromedriver.exe");
             driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/browsers/geckodriver.exe");
            driver=new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/resources/browsers/msedgedriver.exe");
            driver=new EdgeDriver();
        }else {
            throw new RuntimeException("please select correct browser");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverUtil.PAGE_lOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverUtil.IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();
    }


}
