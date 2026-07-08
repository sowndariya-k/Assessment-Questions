@register
Feature: Register Functionality

  Background:
    Given the user is on the DemoWebShop website
    And the user is on the Register page

  Scenario: User should register successfully
    When user enters registration details from "newuser"
    And the user clicks register button
    Then user should see Your registration completed message

  Scenario: Existing user registration should not be successful
    When user enters registration details from "existuser"
    And the user clicks register button
    Then user should see error message