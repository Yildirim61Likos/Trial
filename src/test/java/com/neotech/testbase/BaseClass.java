package com.neotech.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {

	public static WebDriver driver;
	
	
	
	
	public static void setUp() throws InterruptedException
	{
		
		// This line will read the configuration.properties file
				ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

				
				String browser = ConfigsReader.getProperty("browser");
				// System.out.println(browser);


				switch (browser.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

					
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;

				default:
					break;
				}


				
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
				driver.manage().window().maximize();
				
				String website = ConfigsReader.getProperty("url");
				driver.get(website);
				
				PageInitializer.initialize();
		
	}
	
	

	public static void tearDown() 
	{
	
		if(driver!=null) 
		{
			driver.quit();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
