package com.newCredentials.testCases;

import com.newCredentials.driverBase.BaseClass;
import com.newCredentials.pageObject.TC_01_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Test extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {

        logger.info("url is opened");



        TC_01_LoginPage lp =new TC_01_LoginPage(driver);

        lp.setTxtUserName(username);
        logger.info("Enter username");

        lp.setTxtPassWord(password);
       logger.info("Enter password");

          lp.setBtnLogIn();

     if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
     {
        Assert.assertTrue(true);
        logger.info("Login test passed");

     }

     else{
         captureScreenShot(driver,"loginTest");
         Assert.assertTrue(false);
        logger.info("Login test failed");
    }


    }


}
