package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {
        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();
    }
    @Then("The user verify that welcome message is {string}")
    public void the_user_verify_that_welcome_message_is(String expectedUsername) {
        homePage.verifyWelcomeUsername(expectedUsername);
    }
    @When("The user enters {string} and {string} and click login button")
    public void the_user_enters_and_and_click_login_button(String username, String password) {
        loginPage.login(username, password);
    }
    @When("The user enters valid username and passowrd")
    public void the_user_enters_valid_username_and_passowrd(Map<String,String> userInfo) {
      loginPage.login(userInfo.get("username"),userInfo.get("password"));
    }
    @Then("The user verifies that invalid credentials {string}")
    public void the_user_verifies_that_invalid_credentials(String expectedMessage) {
        loginPage.verifyWithPopUpMessage(expectedMessage);
    }

}
