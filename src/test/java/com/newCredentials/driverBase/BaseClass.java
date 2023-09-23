package com.newCredentials.driverBase;

import com.newCredentials.utilities.ReadConfig;
import net.bytebuddy.utility.RandomString;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    ReadConfig readConfig =new ReadConfig();
    //public String chromePath=readConfig.getChromePath();
    public String BaseUrl=readConfig.getApplicationUrl();
    public String username= readConfig.getUsername();
    public String password=readConfig.getPassword();
    //public  String screeshotpath=c+File.separator+"ScreenShotFolder"+File.separator;
    public  WebDriver driver;
    public Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {

        logger = Logger.getLogger("Practice_Framework");
        PropertyConfigurator.configure("Log4j.properties");

        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getfirefoxpath());
            driver = new FirefoxDriver();
        } else if (br.equals("iexplore")) {
            System.setProperty("webdriver.iexplore.driver", readConfig.getiexplorePath());
            driver = new InternetExplorerDriver();
        }
     driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BaseUrl);
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

    public void captureScreenShot(WebDriver driver,String tname) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File target=new File(System.getProperty("user.dir")+"\\ScreenShot\\" +tname +"ss.png");
        FileHandler.copy(source,target);
        System.out.println("ScreenShot taken");
    }

    public String randomestring()
    {
        String generatedstring= RandomString.make(8);
        return(generatedstring);
    }

    public static String randomenum(){
        String generatedstring2= RandomString.make(4);
        return (generatedstring2);
    }

    //        public void captureScreenShotonfailure (ITestResult result){
//            if (result.getStatus() == ITestResult.FAILURE) {
//                try {
//                    TakesScreenshot ss = (TakesScreenshot) driver;
//                    File memoryLocation = ss.getScreenshotAs(OutputType.FILE);
//                    FileHandler.copy(memoryLocation,new File("\\ScreenShot "+"ss1.pnng"));
//                } catch (Exception e) {
//                    e.printStackTrace();
//
//                }
//            }
//        }


}
