package com.neotech.steps;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommondMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void start() throws InterruptedException 
	{
		BaseClass.setUp();
	}

	@After
	public void end(Scenario scenario) 
	{

		byte[] picture;
		
		if (scenario.isFailed()) 
		{
			// store the screenshot in the failed folder
			picture = CommondMethods.takeScreenshot("failed/" + scenario.getName());		
		} else {
			// store the screenshot in the passed folder
			picture = CommondMethods.takeScreenshot("passed/" + scenario.getName());
		}
		
		scenario.attach(picture, "image/png", scenario.getName());

		BaseClass.tearDown();
	}
}
