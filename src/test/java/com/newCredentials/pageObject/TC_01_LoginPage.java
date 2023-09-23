package com.newCredentials.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_01_LoginPage {

    public WebDriver driver;

    public TC_01_LoginPage(WebDriver driver) {
   this.driver=driver;
        PageFactory.initElements(driver,this);
    }


//    public void LoginPage(WebDriver driver){
//       this.driver=driver;
//      // PageFactory.initElements(rdriver,this);
 //  }
  @FindBy(name = "uid")
    WebElement txtUserName;
   @FindBy(name="password")
    WebElement txtPassWord;
   @FindBy(name="btnLogin")
    WebElement btnLogIn;
@FindBy(xpath="//a[text()='Log out']")
WebElement btnLogout;

 public void setTxtUserName(String uname){
    txtUserName.sendKeys(uname);
}
 public void setTxtPassWord(String pswrd){
     txtPassWord.sendKeys(pswrd);
 }
 public void setBtnLogIn(){
     btnLogIn.click();
 }
public void setBtnLogout(){
     btnLogout.click();
}
}
