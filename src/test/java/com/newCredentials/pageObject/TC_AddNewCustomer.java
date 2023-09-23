package com.newCredentials.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TC_AddNewCustomer {

    WebDriver driver;

    public TC_AddNewCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
    WebElement clknewcustomer;
    @FindBy(how = How.NAME, using = "name")
    WebElement txtName;
    @FindBy(how = How.NAME, using = "rad1")
    WebElement rdGender;
    @FindBy(how = How.ID_OR_NAME, using = "dob")
    WebElement txtdob;
    @FindBy(how = How.NAME, using = "addr")
    WebElement txtaddress;
    @FindBy(how = How.NAME, using = "city")
    WebElement txtcity;

    @FindBy(how = How.NAME, using = "state")
    WebElement txtstate;
    @FindBy(how = How.NAME, using = "pinno")
    WebElement txtpin;
    @FindBy(how = How.NAME, using = "telephoneno")
    WebElement txttelephone;

    @FindBy(how = How.NAME, using = "emailid")
    WebElement txtemail;
    @FindBy(how = How.NAME, using = "password")
    WebElement txtpassword;
    @FindBy(how = How.NAME, using = "sub")
    WebElement clicksubmit;

public void setClknewcustomer(){
    clknewcustomer.click();
}

 public void setTxtName(String cname){
    txtName.sendKeys(cname);
 }

  public void setRdGender(String cgender){
    rdGender.click();

  }

   public void setTxtdob(String mm,String dd,String yy){
    txtdob.sendKeys(mm);
    txtdob.sendKeys(dd);
    txtdob.sendKeys(yy);
   }

  public void setTxtaddress(String caddress){
    txtaddress.sendKeys(caddress);
  }
  public void setTxtcity(String ccity){
    txtcity.sendKeys(ccity);

  }
  public void setTxtstate(String cstate){
    txtstate.sendKeys(cstate);
  }
 public void setTxtpin(String cpin){
 txtpin.sendKeys(String.valueOf(cpin));
 }
 public void setTxttelephone(String ctelenum){
 txttelephone.sendKeys(ctelenum);
 }
 public void setTxtemail(String cemail){
   txtemail.sendKeys(cemail);
 }

 public void setTxtpassword(String cpaswrd){
  txtpassword.sendKeys(cpaswrd);
 }
 public void setClicksubmit(){
      clicksubmit.click();

 }

}