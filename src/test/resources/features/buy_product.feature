Feature: Buying Products
  As a user
  I want to buy products on the website
  So that I can complete my purchase

  Scenario: Buying two products
    Given the user is on the DemoBlaze home page
    When the user adds two products to the cart
    And proceeds to the cart page
    And click to placeOrder button
    And completes the order with details
    Then the user should see a successful purchase message
