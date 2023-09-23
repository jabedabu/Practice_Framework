package com.newCredentials.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

  public void onStart(ITestContext testContext){
     String timeStamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
     String repName="Test-Report-" + timeStamp+".html";

     htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\"+repName);

     htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\Extent.Config.xml");

      extent=new ExtentReports();

      extent.attachReporter(htmlReporter);
      extent.setSystemInfo("Host name","localhost");
      extent.setSystemInfo("Environment","QA");
      extent.setSystemInfo("user","Javeed");

       htmlReporter.config().setDocumentTitle("Practice Framework Project");
       htmlReporter.config().setDocumentTitle("Functional Test Report");
        htmlReporter.config().setTheme(Theme.DARK);




  }

     public void onTestSuccess(ITestResult tr){
      logger=extent.createTest(tr.getName());
      logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
     }
            public void onTestFailure(ITestResult tr)
            {

               logger= extent.createTest(tr.getName());
               logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
               String screenshotPath=System.getProperty("user.dir") +"\\ScreenShot\\"+tr.getName()+"ss.png";
                File f=new File(screenshotPath);

                if(f.exists())
                {
                   try{
                     logger.fail("ScreenShot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
                   }
                   catch (Exception e){
                       e.printStackTrace();
                   }
                }

            }

        public void onTestSkipped(ITestResult tr)
        {
            logger=extent.createTest(tr.getName());
            logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
        }

      public void onFinish(ITestContext testContext)

      {
          extent.flush();
      }




//    public void onstart() throws IOException, InterruptedException {
//
//
//
//        htmlReporter = new ExtentHtmlReporter("\\ExtentReport.extentReport.html");
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(htmlReporter);
//        htmlReporter.config().setTheme(Theme.DARK);
//        htmlReporter.config().setReportName("Ui Login");
//        extentReports.setSystemInfo("Automation Engeineer", "javeed");
//
//    }
//
//
//
//    public void  ontestFailure(ITestResult result) throws IOException, InterruptedException {
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//
//            extentTest.log(Status.FAIL, "this is fail" + result.getName());
//            TakesScreenshot obj = (TakesScreenshot) driver;
//            File mamorylocation = obj.getScreenshotAs(OutputType.FILE);
//            FileHandler.copy(mamorylocation, new File("\\ScreenShot\\ss1.png"));
//        }
//        else if (result.getStatus() == ITestResult.SUCCESS) {
//
//            extentTest.log(Status.PASS,"it is pass"+result.getName());
//        }
//
//    }
//    @AfterTest
//    public void KillerBrowser(){
//
//
//    }

//    public void quit(){
//
//        driver.quit();
//        extentReports.flush();
//
//    }


}
