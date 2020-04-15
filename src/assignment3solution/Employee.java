package assignment3solution;

import java.time.LocalDate;

/*
 * Taken from assignment 2 solution
 * Modified 2020-03-30 by Michael Amatucci
 */

public class Employee extends Person {
	protected String employeeID;
	protected String hireDate;
	
	//constructor
	public Employee()
	{
		super();
		employeeID = "-1";
		hireDate = "-1";
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public boolean setEmployeeID(String employeeID) {
		if ( employeeID == null )
			return false;
		
		employeeID = employeeID.trim().replaceAll(" ", "");
		
		if ( !employeeID.matches("\\d{10}") )
			return false;
		
		this.employeeID = employeeID;
		return true;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public boolean setHireDate(String hireDate) {
		if ( hireDate == null )
			return false;
		
		hireDate = hireDate.trim().replaceAll(" ", "");
		
		if ( !hireDate.matches("\\d{4}-\\d{2}-\\d{2}") )
			return false;
		
		int year = Integer.parseInt(hireDate.split("-")[0]);
		int month = Integer.parseInt(hireDate.split("-")[1]);
		int day = Integer.parseInt(hireDate.split("-")[2]);
		
		LocalDate today = LocalDate.now();
		LocalDate hireday = LocalDate.of(year, month, day);
		
		if ( hireday.isAfter(today) )
			return false;
		
		this.hireDate = hireDate;
		return true;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nEmployee ID: " + getEmployeeID();
		toReturn += "\nHire date: " + getHireDate();
		return toReturn;
	}
}
