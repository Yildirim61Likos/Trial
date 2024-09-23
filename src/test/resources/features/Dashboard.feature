Feature: Dashboard Menu

	@menu
  Scenario: Dashboard Menu for Admin
    Given user is logged in with valid credentials
    Then I want to validate the items on the menu
      | Admin           |
      | PIM             |
      | My Info         |
      | Discipline      |
      | Reports Catalog |
      | More            |
      | Maintenance     |
