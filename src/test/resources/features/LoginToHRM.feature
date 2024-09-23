@Login
Feature: Login Functionality

  @login
  Scenario: Valid Login
    #Given I navigated to the HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
    
    @example
    Scenario: Valid Login
    #Given I navigated to the HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in 
    

  #And I will quit the browser
  @invalid
  Scenario: Invalid Password
    #Given I navigated to the HRM website
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate that Invalid Credentials is displayed

  @HW3
  Scenario Outline: Login using Scenario Outline and Examples Table
    When user enters login information "<username>" and "<password>"
    And I click on the login button
    Then verify that "<employeeName>" is showing

    Examples: 
      | username   | password       | employeeName |
      | tonybranch | Tonybranch@123 | Tony Branch  |
      | bobredex   | Bobredex@123   | Bob Redex    |


	@HW3
  Scenario: Login using DataTable
    When user enters username and password and clicks on the login button
      | username   | password       | employeeName |
      | tonybranch | Tonybranch@123 | Tony Branch  |
      | bobredex   | Bobredex@123   | Bob Redex    |
