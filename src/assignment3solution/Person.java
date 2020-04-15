package assignment3solution;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class partially fulfills the requirements of Assignment 1.
 * 
 * @author Giovanni Vincenti
 * @since 2020-02-18
 * @version 1.0
 * 
 * Modified 2020-04-04 by Michael Amatucci
 */

public class Person {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	//constructor
	public Person()
	{
		firstName = "NONE";
		lastName = "None";
		dateOfBirth = null;
	}
	
	/**
	 * Used to get the first name of the person, composed of 2-20
	 * characters including a-z, spaces, dashes, and apostrophes
	 * 
	 * @return A String containing the first name of the person
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Used to set the first name of the person. The value must contain 2-20 characters,
	 * including a-z, spaces, dashes, and apostrophes.
	 * 
	 * @param firstName A String containing the first name of the person
	 * @return A true/false value that specifies whether the first name was valid and stored, or not
	 */
	
	public boolean setFirstName(String firstName) {
		if ( firstName == null )
			return false;
		
		// Removes leading and trailing whitespace characters
		firstName = firstName.trim();
		
		// Replaces extra spaces
		firstName = firstName.replaceAll(" +", " ");
		
		if ( firstName.length() < 2 || firstName.length() > 20 )
			return false;
		
		if ( !firstName.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.firstName = firstName;
		return true;
	}
	
	/**
	 * Used to get the last name of the person, composed of 2-20
	 * characters including a-z, spaces, dashes, and apostrophes
	 * 
	 * @return A String containing the last name of the person
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Used to set the last name of the person. The value must contain 2-20 characters,
	 * including a-z, spaces, dashes, and apostrophes.
	 * 
	 * @param lastName A String containing the first name of the person
	 * @return A true/false value that specifies whether the last name was valid and stored, or not
	 */
	
	public boolean setLastName(String lastName) {
		if ( lastName == null )
			return false;
		
		lastName = lastName.trim();
		
		lastName = lastName.replaceAll(" +", " ");
		
		if ( lastName.length() < 2 || lastName.length() > 20 )
			return false;
		
		if ( !lastName.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.lastName = lastName;
		return true;
	}
	
	/**
	 * Used to get the date of birth of the person, in the format YYYY-MM-DD
	 * 
	 * @return A String containing the date of birth of the person
	 */
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Used to set the date of birth of the person, in the format YYYY-MM-DD
	 * 
	 * @param dateOfBirth A String containing the date of birth of the person
	 * @return A true/false value that specifies whether the date was valid and stored, or not
	 */
	
	public boolean setDateOfBirth(String dateOfBirth) {
		if ( dateOfBirth == null )
			return false;
		
		dateOfBirth = dateOfBirth.trim();
		
		if ( !dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}") )
			return false;
		
		int year = Integer.parseInt(dateOfBirth.split("-")[0]);
		int month = Integer.parseInt(dateOfBirth.split("-")[1]);
		int day = Integer.parseInt(dateOfBirth.split("-")[2]);
		
		LocalDate today = LocalDate.now();
		LocalDate bday = LocalDate.of(year, month, day);
		
		if ( bday.isAfter(today) )
			return false;
		
		this.dateOfBirth = dateOfBirth;
		return true;
	}
	
	public int getAge() {
		int age = -1;
		
		if ( dateOfBirth == null )
			return age;
		
		int year = Integer.parseInt(dateOfBirth.split("-")[0]);
		int month = Integer.parseInt(dateOfBirth.split("-")[1]);
		int day = Integer.parseInt(dateOfBirth.split("-")[2]);
		
		LocalDate today = LocalDate.now();
		LocalDate bday = LocalDate.of(year, month, day);
		
		age = Math.abs(Period.between(today, bday).getYears());
		
		return age;
	}
	
	public String toString() {
		String toReturn = "Name: " + getFirstName() + " " + getLastName();
		toReturn += "\nDate of Birth: " + getDateOfBirth() + ", Age: " + getAge();
		return toReturn;
	}
}
