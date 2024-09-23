package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommondMethods;

public class PersonalDetailsPageElements extends CommondMethods{

	

	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement personalDetailsForm;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "pim.navbar.employeeName")
	public WebElement employeeName;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "licenseNo")
	public WebElement licenseNo;

	@FindBy(xpath = "//label[text()='Smoker']")
	public WebElement smokerCheck;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']")
	public WebElement genderInput;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/ul/li")
	public List<WebElement> genderOptions;

	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']/div/input")
	public WebElement nationalityInput;

	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']/div/ul/li")
	public List<WebElement> nationalityOptions;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/parent::div//i")
	public WebElement licExpDate;

	@FindBy(xpath = "//div[@class='select-wrapper picker__select--year']/input")
	public WebElement licExpYearInput;

	@FindBy(xpath = "//div[@class='select-wrapper picker__select--year']/ul/li")
	public List<WebElement> licExpYearOptions;

	@FindBy(xpath = "//div[@class='select-wrapper picker__select--month']/input")
	public WebElement licExpMonthInput;

	@FindBy(xpath = "//div[@class='select-wrapper picker__select--month']/ul/li")
	public List<WebElement> licExpMonthOptions;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/..//table/tbody/tr/td")
	public List<WebElement> licExpDayOptions;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement detailsSaveBtn;
	
	
	@FindBy(xpath="//div[@id='eeo_race_ent_inputfileddiv']/div/input")
	public WebElement ethnicityInput;
	
	@FindBy(xpath = "//select[@id='eeo_race_ent']/preceding-sibling::ul/li")
	public List<WebElement> ethnicityOptions;
	
    @FindBy(xpath="//select[@id='1']/parent::div/input")
	public WebElement bloodInput;
    
	@FindBy(xpath = "//select[@id='1']/preceding-sibling::ul/li")
	public List<WebElement> bloodOptions;

	
	@FindBy(xpath="//select[@id='19']/parent::div/input")
	public WebElement shirtSizeInput;
	
	@FindBy(xpath = "//select[@id='19']/parent::div/ul/li")
	public List<WebElement> shirtSizeOptions;
	
	public PersonalDetailsPageElements() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
}
