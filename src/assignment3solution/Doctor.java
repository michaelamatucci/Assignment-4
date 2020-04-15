package assignment3solution;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Taken from assignment 2 solution
 * Modified 2020-03-30 by Michael Amatucci
 */

public class Doctor extends Employee {
	private String specialty;
	private boolean canOperate;
	
	//constructor
	public Doctor()
	{
		super();
		specialty = "NONE";
		canOperate = false;
	}
	
	//overrides Employee method
	//checks if MD proceeds employee ID numbers
	
	public boolean setEmployeeID(String employeeID) {
		if ( employeeID == null )
			return false;
		
		employeeID = employeeID.trim().replaceAll(" ", "");
		
		if ( !employeeID.matches("MD" + "\\d{8}") )
			return false;
		
		this.employeeID = employeeID;
		return true;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public boolean setSpecialty(String specialty) {
		if ( specialty == null )
			return false;
		
		specialty = specialty.trim().replaceAll(" +", " ");
		
		try {
			// The JSON file should be in the 'src' folder of your project.
			JSONArray specialties = (JSONArray) (new JSONParser()).parse(new FileReader("src/specialties.json"));
			for ( Object spec : specialties ) {
				String specialtyName = (String)((JSONObject)spec).get("Specialty");
				if (specialty.equalsIgnoreCase(specialtyName)) {
					this.specialty = specialty;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean canOperate() {
		return canOperate;
	}
	
	public void setCanOperate(boolean canOperate) {
		this.canOperate = canOperate;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSpecialty: " + getSpecialty();
		toReturn += "\nThis doctor can" + (canOperate()?"":"not") + " perform surgery";
		return toReturn;
	}
}
