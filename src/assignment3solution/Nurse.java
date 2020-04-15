package assignment3solution;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Taken from assignment 2 solution
 * Modified 2020-03-30 by Michael Amatucci
 */

public class Nurse extends Employee {
	private String department;
	private boolean canPrescribe;
	
	//constructor
	public Nurse()
	{
		super();
		department = "NONE";
		canPrescribe = false;
	}
	
	//overrides Employee method
	//checks if RN proceeds ID numbers
	
	public boolean setEmployeeID(String employeeID) {
		if ( employeeID == null )
			return false;
		
		employeeID = employeeID.trim().replaceAll(" ", "");
		
		if ( !employeeID.matches("RN" + "\\d{8}") )
			return false;
		
		this.employeeID = employeeID;
		return true;
	}

	public String getDepartment() {
		return department;
	}
	
	public boolean setDepartment(String department) {
		if ( department == null )
			return false;
		
		department = department.trim().replaceAll(" +", " ");
		
		try {
			// The JSON file should be in the 'src' folder of your project.
			JSONArray departments = (JSONArray) (new JSONParser()).parse(new FileReader("src/departments.json"));
			for ( Object dept : departments ) {
				String departmentName = (String)((JSONObject)dept).get("Department");
				if (department.equalsIgnoreCase(departmentName)) {
					this.department = department;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean canPrescribe() {
		return canPrescribe;
	}
	
	public void setCanPrescribe(boolean canPrescribe) {
		this.canPrescribe = canPrescribe;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nDepartment: " + getDepartment();
		toReturn += "\nThis nurse can" + (canPrescribe()?"":"not") + " prescribe medications";
		return toReturn;
	}
}
