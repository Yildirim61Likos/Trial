package com.neotech.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps {

	@Given("Precondition1")
	public void precondition1() {
		System.out.println("Running Precondition1!");
	}

	@Given("Precondition2")
	public void precondition2() {
		System.out.println("Running Precodition2!");
	}

	@When("Test nr1")
	public void test_nr1() {
		System.out.println("Running Test nr1!");
	}
	
	@When("Test nr1 firstName is {string} and lastName is {string}")
	public void test_nr1_first_name_is_and_last_name_is(String firstName, String lastName) {
		System.out.println("Running Test nr1 with firstName: " + firstName + 
				" and lastName: " + lastName);
	}

	@When("Test nr2")
	public void test_nr2() {
		System.out.println("Running Test nr2");
	}

	@When("Test nr3")
	public void test_nr3() {
		System.out.println("Running Test nr3");
	}

	@Then("Validation nr1")
	public void validation_nr1() {
		System.out.println("Running Validation nr1");
	}

	@Then("Validation nr2")
	public void validation_nr2() {
		System.out.println("Running Validation nr2");
	}

	@When("Test nr4")
	public void test_nr4() {
		System.out.println("Running Test nr4");
	}
	@When("Test nr5")
	public void test_nr5() {
		System.out.println("Running Test nr5");
	}
	@When("Test nr6")
	public void test_nr6() {
		System.out.println("Running Test nr6");
	}
	@Then("Validation nr3")
	public void validation_nr3() {
		System.out.println("Running Validation nr3");
	}
	@Then("Validation nr4")
	public void validation_nr4() {
		System.out.println("Running Validation nr4");
	}
	
	
	
}
