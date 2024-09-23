package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommondMethods;
import com.neotech.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommondMethods {

	@Given("user navigates to AddEmployee page")
	public void user_navigates_to_add_employee_page() {
		click(dash.PIM);
		click(dash.addEmployeeLink);
	}

	// Hard-coded step
	@When("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() {
		sendText(addEmployee.firstName, "Lionel");
		sendText(addEmployee.lastName, "Messi");
	}

	// Parameterized step
	@When("user enters employee first name {string} and last name {string}")
	public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) {
		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);
	}

	@When("user selects a location")
	public void user_selects_a_location() {
		selectDropdown(addEmployee.location, "New York Sales Office");
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		wait(1);
		click(addEmployee.saveButton);
	}

	// Hard-coded Validation
	@Then("validate that employee is added successfully")
	public void validate_that_employee_is_added_successfully() {
		waitForVisibility(personalDetails.personalDetailsForm);

		String expected = "Lionel Messi";
		String actual = personalDetails.employeeName.getText();

		// Please make sure you import the Assert class under org.junit package
		Assert.assertEquals("The employee name DOES NOT match!", expected, actual);
	}

	// Parameterized Validation
	@Then("validate that employee {string} is added successfully")
	public void validate_that_employee_is_added_successfully(String expectedName) {
		waitForVisibility(personalDetails.personalDetailsForm);

		String actualName = personalDetails.employeeName.getText();

		// Please make sure you import the Assert class under org.junit package
		Assert.assertEquals("The employee name DOES NOT match!", expectedName, actualName);
	}

	@When("user clicks on Create Login Details")
	public void user_clicks_on_create_login_details() {
		jsClick(addEmployee.loginDetailsToggle);
	}

	@When("user provides credentials")
	public void user_provides_credentials() {
		sendText(addEmployee.username, "MarioIcardi");
		sendText(addEmployee.password, "Wanda@123");
		sendText(addEmployee.confirmPassword, "Wanda@123");
	}

	// Homework for Hard working students
	// Do the step above with parameterized username and password

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String first, String middle, String last) {
		sendText(addEmployee.firstName, first);
		sendText(addEmployee.middleName, middle);
		sendText(addEmployee.lastName, last);
	}

	@When("user selects a location {string}")
	public void user_selects_a_location(String location) {
		selectDropdown(addEmployee.location, location);
	}

	@Then("validate that {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String firstName, String lastName) {
		waitForVisibility(personalDetails.personalDetailsForm);

		String expectedName = firstName + " " + lastName;
		String actualName = personalDetails.employeeName.getText();

		// Please make sure you import the Assert class under org.junit package
		Assert.assertEquals("The employee name DOES NOT match!", expectedName, actualName);
	}

	// ----------------@UsingDataTable----------------

	@When("user enters employee details and clicks on save and validates it is added")
	public void user_enters_employee_details(DataTable table) {
		// System.out.println(table);

		// asLists() method returns a List for every row (including the header)
		// System.out.println(table.asLists());

		// asMaps() method returns a List of Maps for every data row
		// (NOT including the header)
		// System.out.println(table.asMaps());

		List<Map<String, String>> employeeList = table.asMaps();

		for (Map<String, String> employee : employeeList) {
			System.out.println(employee);

			String fName = employee.get("FirstName");
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");

			sendText(addEmployee.firstName, fName);
			sendText(addEmployee.middleName, mName);
			sendText(addEmployee.lastName, lName);

			selectDropdown(addEmployee.location, "France Regional HQ");
			wait(1);

			click(addEmployee.saveButton);

			waitForVisibility(personalDetails.personalDetailsForm);

			// Validation
			String expectedName = fName + " " + lName;
			String actualName = personalDetails.employeeName.getText();

			Assert.assertEquals("The employee name DOES NOT match!", expectedName, actualName);

			// Before the next iteration
			// We need to go to Add Employee page again
			wait(1);
			click(dash.addEmployeeLink);
		}

	}

	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String driverLicense, String expirationDate, String smoker,
			String gender, String nationality) {

		waitForVisibility(personalDetails.personalDetailsForm);

		sendText(personalDetails.licenseNo, driverLicense);

		if (smoker.equals("Yes")) {
			click(personalDetails.smokerCheck);
		}
		wait(2);

		// 1st way
		click(personalDetails.genderInput);
//		click(driver.findElement(By.xpath("//span[text()='" + gender + "']")));

		// 2nd way
		List<WebElement> genderOptions = personalDetails.genderOptions;
		clickOnElement(genderOptions, gender);

		wait(2);

		click(personalDetails.nationalityInput);

		List<WebElement> nationalityOptions = personalDetails.nationalityOptions;
		clickOnElement(nationalityOptions, nationality);

		wait(2);

		// This will show the calendar
		click(personalDetails.licExpDate);

		// Date parameter: 2023-05-10
		// Select year
		String[] dateParts = expirationDate.split("-");
		String year = dateParts[0];
		click(personalDetails.licExpYearInput);
		clickOnElement(personalDetails.licExpYearOptions, year);
		wait(2);

		// select month
		int month = Integer.parseInt(dateParts[1]); // returns 5 as integer
		click(personalDetails.licExpMonthInput);
		click(personalDetails.licExpMonthOptions.get(month - 1));
		wait(2);

		// select day
		int day = Integer.parseInt(dateParts[2]);
		selectCalendarDate(personalDetails.licExpDayOptions, day + "");
		
		wait(1);
		
		String group="AB";
		click(personalDetails.bloodInput);
		clickOnelement(personalDetails.bloodOptions,group);
		
		

		wait(4);
	}

	public void clickOnElement(List<WebElement> list, String value) {
		wait(1);
		for (WebElement option : list) {
			if (option.getText().equals(value)) {
				click(option);
				break;
			}
		}
	}

	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {
		jsClick(personalDetails.detailsSaveBtn);
		wait(3);
	}

	@When("user enters employee data from {string} excel sheet then save")
	public void user_enters_employee_data_from_excel_sheet_then_save(String sheetName) 
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
		
		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, sheetName);

		// Finish this just like the previous method that uses DataTable
		
		for(Map<String,String> map:excelList) 
		{
			String name= map.get("FirstName");
			String lastName = map.get("LastName");

			sendText(addEmployee.firstName, name);
			sendText(addEmployee.lastName, lastName);

			selectDropdown(addEmployee.location, "France Regional HQ");
			wait(1);

			jsClick(addEmployee.loginDetailsToggle);
			
			wait(1);
			String username=map.get("Username");
			String password=map.get("Password");
			
			sendText(addEmployee.username,username);
			wait(1);
			sendText(addEmployee.password,password);
			wait(1);
			sendText(addEmployee.confirmPassword,password);
			wait(1);
	
			click(addEmployee.saveButton);
			waitForVisibility(personalDetails.personalDetailsForm);
			
			String expectedName = name + " " + lastName;
			String actualName = personalDetails.employeeName.getText();
			Assert.assertEquals("The employee name DOES NOT match!", expectedName,actualName );
			
			wait(1);
			click(dash.addEmployeeLink);
		}
		
	}
	
	
	
	
	@Then("user provide a blood group")
	public void user_provide_a_blood_group() 
	{
		waitForVisibility(personalDetails.personalDetailsForm);
		
		
	}

	
	public void clickOnelement(List<WebElement> list,String value) 
	{
		for(WebElement el:list) 
		{
			String text=el.getText();
			if(text.equals(value)) 
			{
				click(el);
				break;
			}
		}
	}
	
	
	
	/*--------------------------------
	Class 05
	--------------------------------
	1. Homework: 
	    - Do a dryRun to get the unimplemented steps
	    - Locate the elements under PersonalDetailsPageElements.java
	    - Implement the steps under PersonalDetailsSteps.java
	    
	    - Locate all the drop-down ListItems as a List<WebElement>
	    - Created a method clickOnElement() to click on one of the ListItems

	2. Excel Data Driven Testing
		- Scenario is created same way as for a simple test step
		- Similar to dataTable implementation
			- Most of the work is done on the java step method
			- The driver is loaded only once, because the loops are coded in java
		- We created a method excelIntoListOfMaps() in ExcelUtility.java class
			- We want to get the table in excel file in a List of Maps data structure
		- Once we have the list of maps, the rest of the code is same as with using dataTables
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
