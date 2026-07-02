Feature: Address Book Feature

  @AddressBook

  Scenario: Add new address using Data Table

    Given User login to TutorialsNinja application
    When User enters address details

      | firstname | John            |
      | lastname  | Doe             |
      | address1  | 123 Main Street |
      | city      | Chennai         |
      | postcode  | 600001          |
      | country   | India           |
      | region    | Tamil Nadu      |

    And User click on continue button
    Then Address should be added successfully