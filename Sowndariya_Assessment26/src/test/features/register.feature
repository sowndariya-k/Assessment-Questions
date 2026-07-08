@register
Feature: Register Functionality

  Background:
    Given the user is on the DemoWebShop homepage
    When the user clicks the "Register" link

  Scenario: Verify successful registration
    When the user enters firstname "sownd"
    And the user enters lastname "K"
    And the user enters email "sownd12345@testmail.com"
    And the user enters password "Sow@123"
    And the user enters confirm password "Sow@123"
    And the user clicks the "Register" button
    Then the page should display the message "Your registration completed"