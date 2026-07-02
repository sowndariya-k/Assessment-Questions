Feature: Search on TutorialsNinja

@Search

Scenario Outline: Search feature with keywords

  Given User is on TutorialsNinja home page
  When User enter Keyword search as "<keyword>"
  And User click on search button
  Then User should see search result status as "<result_status>"
 

    Examples:
 | keyword | result_status |
 | iPhone  | contain       |
 | Samsung | contain       |
 | Nik     | contain       |
 | Mik     |not contain    |
 