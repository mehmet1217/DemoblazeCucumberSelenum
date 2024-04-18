package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername;
    @FindBy(xpath = "//a[text()='Add to cart']")
    public WebElement addtoCart;



    public void verifyWelcomeUsername(String expectedUsername){
        String actualUsername=welcomeUsername.getText();
        Assert.assertEquals("username does NOT match",expectedUsername,actualUsername);
        System.out.println("actualUsername = " + actualUsername);
    }

    public void addProduct(String category,String product){
        /*
        String categoryMenu="//a[text()='"+category+"']";
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath(categoryMenu)).click();
        BrowserUtils.waitFor(1);
        String item="//a[text()='"+product+"']";
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath(item)).click();
        BrowserUtils.waitFor(1);
        */
        String categoryMenu="//a[text()='"+category+"']";
        String item="//a[text()='"+product+"']";

        try {
            BrowserUtils.waitForClickablility(By.xpath(categoryMenu),5);
            WebElement categoryElm=Driver.get().findElement(By.xpath(categoryMenu));
            categoryElm.click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(categoryMenu),5);
        }
        try {
            BrowserUtils.waitForClickablility(By.xpath(item),5);
            WebElement productItem=Driver.get().findElement(By.xpath(item));
            productItem.click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(item),5);
        }


        addtoCart.click();
        BrowserUtils.waitFor(1);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();

        homeMenu.click();

    }

}
