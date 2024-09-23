package com.neotech.testbase;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.EmployeeListPageElements;
import com.neotech.pages.LoginPageElements;

import com.neotech.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static DashboardPageElements dash;
	public static AddEmployeePageElements addEmployee;
	public static PersonalDetailsPageElements personalDetails;
	public static EmployeeListPageElements employeeList;
	
	public static void initialize () 
	{
		login =new LoginPageElements();
		dash =new DashboardPageElements();
		addEmployee=new AddEmployeePageElements();
		personalDetails=new PersonalDetailsPageElements();
		employeeList=new EmployeeListPageElements();
		
	}
	
	
	
	
}
