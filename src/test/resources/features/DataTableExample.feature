Feature: Scenarios with DataTable

	@dataTable
  Scenario: Add Employee with DataTable
    When I login to the HRMS
    And I want to add Employees
      | FirstName | MiddleName | LastName |
      | Emre      |            | Cinar    |
      | Cihan     | Boss       | Abbak    |
      | Omer      | Faruk      | Turkoglu |
		Then I validate employee is added