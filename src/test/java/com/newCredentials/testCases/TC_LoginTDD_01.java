package com.newCredentials.testCases;

import com.newCredentials.dataReader.TestData;
import com.newCredentials.driverBase.BaseClass;
import com.newCredentials.pageObject.TC_01_LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTDD_01 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginTDD(String user, String pwd) throws InterruptedException {
        TC_01_LoginPage lp=new TC_01_LoginPage(driver);
         lp.setTxtUserName(user);
         logger.info("user name provided");

         lp.setTxtPassWord(pwd);
        logger.info("password provided");
         lp.setBtnLogIn();
      Thread.sleep(3000);

       if(isAlertPresent()==true)
       {
           driver.switchTo().alert().accept();
           driver.switchTo().defaultContent();
           Assert.assertTrue(false);
      logger.warn("login failed");

       }
    else
    {
    Assert.assertTrue(true);
      logger.info("login passed ");

    lp.setBtnLogout();
      driver.switchTo().alert().accept();
       driver.switchTo().defaultContent();
    }

    }

    public boolean isAlertPresent()
    {
        try{
            driver.switchTo().alert();
            return true;
        }
       catch (NoAlertPresentException e) {
           return false;
       }
    }


    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\newCredentials\\dataReader\\My_xls_File.xlsx";

    int rownum= TestData.getRowCount(path,"Sheet1");
    int colcount=TestData.getCellCount(path,"Sheet1",1);

    String logindata[][]=new String[rownum][colcount];

    for(int i=1;i<=rownum;i++)
      {
          for(int j=0;j<colcount;j++)
          {
              logindata[i-1][j]=TestData.getCellData(path,"Sheet1",i,j);

          }
      }
    return logindata;
    }


    }


