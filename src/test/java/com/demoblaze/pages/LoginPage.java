package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "login2")
    public WebElement loginHomePage;
    @FindBy(id = "loginusername")
    public WebElement usernameInput;
    @FindBy(id = "loginpassword")
    public WebElement passwordInput;
    @FindBy(css = "[onclick='logIn()']")
    public WebElement submitBtn;


    public void login(){
        String userName= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginHomePage.click();
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        submitBtn.click();
        BrowserUtils.waitFor(2);
    }
    public void login(String userName,String password){
        loginHomePage.click();
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        submitBtn.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyWithPopUpMessage(String expectedMessage){
        Alert alert= Driver.get().switchTo().alert();
        String actualMessage = alert.getText();

        Assert.assertEquals("Message does NOT match",expectedMessage,actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
    }

}
