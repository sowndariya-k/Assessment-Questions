@login
Feature: Login Functionality

  Background:
    Given the user is on the DemoWebShop Login page
    And User click the login link

  Scenario Outline: Verify login with valid and invalid credentials
  And User enter the email as "<email>"
  And User enter the password1 as "<password>"
  When User click login button
  Then User should see "<result>"

Examples:
  | email                | password | result        |
  | 2k22it51@kiot.ac.in  | Sow@911! | Account       |
  | 2k22it51@kiot.ac.in  | Sow@911  | The credentials provided are incorrect. |
  | 2k22it51@gmail.ac.in | Sow@911! | Login was unsuccessful. Please correct the errors and try again. |
