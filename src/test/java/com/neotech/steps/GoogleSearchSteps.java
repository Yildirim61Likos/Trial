package com.neotech.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {



	@When("I type something in the search box")
	public void i_type_something_in_the_search_box() {
	   System.out.println("I search for puppy images");
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
	    System.out.println("Click on search");
	}

	@Then("I can see the results of my search")
	public void i_can_see_the_results_of_my_search() {
		System.out.println("Validate that results are showing");
	}

	@Then("I can count the number of the results")
	public void i_can_count_the_number_of_the_results() {
		System.out.println("Count the number of the results");
	}

	@When("I say what I want to search")
	public void i_say_what_i_want_to_search() {
	    System.out.println("Say puppy images");
	}
	
	
	@Given("I navigated to Google")
	public void i_navigated_to_google() {
	    System.out.println("I go to Google Page");
	}


}
