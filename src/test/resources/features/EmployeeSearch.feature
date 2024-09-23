@searchEmployee
Feature: Search Employee

  @smoke @regression
  Scenario: Search for Employee by ID
    Given user is logged in with valid credentials
    And user navigates to employee list page
    When user enters valid employee id
    And clicks on search button
    Then employee information is displayed

  @regression
  Scenario: Search for Employee by Name
    Given user is logged in with valid credentials
    And user navigates to employee list page
    When user enters valid employee first and last name
    And clicks on search button
    Then employee information is displayed
    