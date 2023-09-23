package com.newCredentials.testCases;

import com.newCredentials.driverBase.BaseClass;
import com.newCredentials.pageObject.TC_01_LoginPage;
import com.newCredentials.pageObject.TC_AddNewCustomer;
import com.newCredentials.utilities.ReadConfig;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static net.bytebuddy.utility.RandomString.*;

public class TC_AddCustomerTest extends BaseClass {
   @Test()
    public void addNewCustomer() throws InterruptedException, IOException {
        TC_01_LoginPage lp =new TC_01_LoginPage(driver);
           lp.setTxtUserName(username);
           logger.info("user name provideed");
           lp.setTxtPassWord(password);
          logger.info("password provided");
           lp.setBtnLogIn();

           Thread.sleep(3000);

       TC_AddNewCustomer addcus=new TC_AddNewCustomer(driver);
         addcus.setClknewcustomer();
         logger.info("provide user details");

         addcus.setTxtName("Don Sifat");
         logger.info("username provided");
         addcus.setRdGender("male");

          addcus.setTxtdob("06","04","94");


          Thread.sleep(3000);

          addcus.setTxtaddress("428 East 48 street ");
          addcus.setTxtcity("Queens");
          addcus.setTxtstate("Indiana");
          addcus.setTxtpin("200023");
          addcus.setTxttelephone("01815328070");
         String email= randomestring()+"@gmail.com";
         addcus.setTxtemail(email);
          addcus.setTxtpassword("abcdfe");
          addcus.setClicksubmit();

           Thread.sleep(3000);

           logger.info("my validation is started");

       boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
    if(res==true)
    {
        Assert.assertTrue(true);
        logger.info("test case passed....");
    }
       else {
           captureScreenShot(driver,"addNewCustomer");

      Assert.assertTrue(false);
      logger.info("test cases failed");
       }

   }



}
