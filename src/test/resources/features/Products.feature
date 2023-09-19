@products @all
Feature: Saucedemo - Products Tests

  Background:
    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs

    Scenario: Open a Product
      And I click on the Product Name
      Then The Product Page Details should be opened

