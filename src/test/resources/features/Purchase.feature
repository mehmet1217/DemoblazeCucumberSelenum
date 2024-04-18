Feature: The user should be able to place order from the website

  @purchase
  Scenario: Placing a successful order
    Given The user is on the login page
    When The user enters "JakeBouver" and "Test1234" and click login button
    And The user add "Samsung galaxy s7" from "Phones"
    And The user add "Sony vaio i5" from "Laptops"
    And The user add "MacBook Pro" from "Laptops"
    And The user add "Apple monitor 24" from "Monitors"
    And The user removes "Sony vaio i5" from cart
    And The user place order and captures and log amount
    Then The user verifies purchase amount equals 2300