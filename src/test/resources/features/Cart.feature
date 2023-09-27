@cart @all
Feature: Saucedemo - Cart Page Tests
  Background:
    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs

  Scenario: Validate the Cart Items number - Add Product to the Cart
    And The Shopping_cart_badge should not be displayed
    And I click in Add To Cart button in first product
    Then The Shopping_cart_badge should count 1

  Scenario: Remove Product from Cart
    And I click in Add To Cart button in first product
    And I click in Cart Icon
    And I should be redirected to Cart Page
    And I click in button to Remove From Cart
    Then The Shopping_cart_badge should not be displayed
