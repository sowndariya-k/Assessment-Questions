@login
Feature: Login Functionality

  Background:
    Given user launches the Demo Web Shop website
    And the user is on the Demo Web Shop login page
    And user clicks the login link

  Scenario: Successful login with valid credentials
    When the user logs in with valid credentials
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the user email should be displayed in the header
    And the Log out link should be visible

  Scenario: Login with invalid credentials
    When the user logs in with invalid credentials
    And the user clicks the Log in button
    Then the appropriate error message should be displayed
    And the user should remain on the login page