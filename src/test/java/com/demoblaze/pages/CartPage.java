package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderBtn;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "card")
    public WebElement creditCard;
    @FindBy(id = "month")
    public WebElement month;
    @FindBy(id = "year")
    public WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseBtn;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmationMessage;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement ok_Btn;


    public void removeProduct(String product){

        BrowserUtils.waitForClickablility(cartMenu,5);
        cartMenu.click();
        WebElement deleteProduct = Driver.get().findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//a[.='Delete']"));
        BrowserUtils.waitForClickablility(deleteProduct,5).click();
        BrowserUtils.waitFor(2);

    }
    public void fillForm() {
        Faker faker = new Faker();
        BrowserUtils.waitFor(1);
        name.sendKeys(faker.gameOfThrones().character());
        BrowserUtils.waitFor(1);
        country.sendKeys(faker.gameOfThrones().house());
        BrowserUtils.waitFor(1);
        city.sendKeys(faker.gameOfThrones().city());
        BrowserUtils.waitFor(1);
        creditCard.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        BrowserUtils.waitFor(1);
        year.sendKeys(String.valueOf(faker.number().numberBetween(2023, 2030)));
        BrowserUtils.waitFor(1);

    }

    int actualAmount;

    public void finishPurchaseAndLogAmount(){
        BrowserUtils.waitForClickablility(placeOrderBtn,5).click();
        BrowserUtils.waitFor(2);
        fillForm();
        purchaseBtn.click();

        BrowserUtils.waitForVisibility(confirmationMessage,5);
        String confirmationText= confirmationMessage.getText();

        String[] confirmationArray = confirmationText.split("\n");

        actualAmount=Integer.parseInt(confirmationArray[1].split(" ")[1]);
        System.out.println("actualAmount = " + actualAmount);

        BrowserUtils.waitForVisibility(ok_Btn,5).click();

    }

    public void verifyPurchaseAmount(int expectedAmount){
        Assert.assertEquals("Amount does NOT Match",expectedAmount,actualAmount);
    }

}
