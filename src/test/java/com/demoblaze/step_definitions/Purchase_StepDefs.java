package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();

    @When("The user add {string} from {string}")
    public void the_user_add_from(String product, String category) {
        homePage.addProduct(category, product);
    }

    @When("The user removes {string} from cart")
    public void the_user_removes_from_cart(String product) {
        cartPage.removeProduct(product);
    }

    @When("The user place order and captures and log amount")
    public void the_user_place_order_and_captures_and_log_amount() {
        cartPage.finishPurchaseAndLogAmount();
    }

    @Then("The user verifies purchase amount equals {int}")
    public void the_user_verifies_purchase_amount_equals(int expectedAmount) {
        cartPage.verifyPurchaseAmount(expectedAmount);
    }
}
