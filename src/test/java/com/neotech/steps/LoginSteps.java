package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommondMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginSteps extends CommondMethods {

//	LoginPageElements login;
//	DashboardPageElements dashboard;

//	@Given("I navigated to the HRM website")
//	public void i_navigated_to_the_hrm_website() throws InterruptedException {
//		setUp();
//
////		login = new LoginPageElements();
////		dashboard = new DashboardPageElements();
//	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}
	
	
	
	
	
	@When("I enter a valid usernamee")
	public void i_enter_a_valid_usernamee() 
	{
	   sendText(login.username, ConfigsReader.getProperty("username"));
	}
	

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.loginButton);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {
		String expected = "Jacqueline White";
		String actual = dash.accountName.getText();

		if (actual.equals(expected)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test failed");
		}

	}

//	@Then("I will quit the browser")
//	public void i_will_quit_the_browser() {
//
//		tearDown();
//
//	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		sendText(login.password, "wrongPassword!");
	}

	@Then("I validate that Invalid Credentials is displayed")
	public void i_validate_that_invalid_credentials_is_displayed() {
		String expectedText = "Invalid Credentials";
		String actualText = login.wrongCredentialsMessage.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!!!");
		}
	}
	
	
	@When("user enters login information {string} and {string}")
	public void user_enters_login_information_and(String username, String password) {
		
		sendText(login.username, username);
		sendText(login.password, password);
	}

	@Then("verify that {string} is showing")
	public void verify_that_is_showing(String expectedAccountName) {

		String actualName  = dash.accountName.getText();
		
		Assert.assertEquals("The account name did not match!!!", expectedAccountName, actualName);
	}
	
	@When("user enters username and password and clicks on the login button")
	public void user_enters_username_and_password_and_clicks_on_the_login_button(DataTable dataTable) {

		//TODO
		//For every row of the DataTable
		//send login credentials 
		//click login
		//verify
		//logout --> this is needed to send us back to the login screen and
					//be ready for the next row
		
		//get the data in a list of maps
		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		
		for (Map<String, String> map : listOfMaps)
		{
			System.out.println("Testing: " + 
					map.get("username") + " : " + 
					map.get("password"));
			
			//login
			sendText(login.username, map.get("username"));
			sendText(login.password, map.get("password"));
			
			click(login.loginButton);
			
			wait(1);
			
			//take a screenshot
			
			
			//validate
			String actualAccountName = dash.accountName.getText();
			
			Assert.assertEquals(map.get("employeeName"), actualAccountName);
			
			
			//logout
			click(dash.accountName);
			click(dash.logout);
			
		}
		
	}

	
	
	

}
