package com.neotech.steps;

import com.neotech.utils.CommondMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeSteps extends CommondMethods {
	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		login.adminLogin();
	}

	@Given("user navigates to employee list page")
	public void user_navigates_to_employee_list_page() {
		click(dash.PIM);
		click(dash.employeeList);
	}

	@When("user enters valid employee first and last name")
	public void user_enters_valid_employee_first_and_last_name() {
		sendText(employeeList.searchBox, "Brody Alan");
		wait(3);
	}

	@When("clicks on search button")
	public void clicks_on_search_button() {
		click(employeeList.searchIcon);
	}

	@Then("employee information is displayed")
	public void employee_information_is_displayed() {
		System.out.println("Yes i see it!");
		wait(5);
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
		sendText(employeeList.searchBox, "1000");
		wait(5);
	}

}
