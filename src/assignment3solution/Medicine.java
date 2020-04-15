package assignment3solution;

import java.time.LocalDate;

/**
 * This class partially fulfills the requirements of Assignment 1.
 * 
 * @author Giovanni Vincenti
 * @since 2020-02-18
 * @version 1.0
 * 
 * Modified 2020-04-04 by Michael Amatucci
 */

public class Medicine {
	private String name;
	private String manufacturer;
	private String expirationDate;
	private int quantity;
	private String unit;
	
	public static final String[] ACCEPTABLE_UNITS = {"Milliliters", "Grams", "Capsules"};
	
	//constructor
	public Medicine()
	{
		name = "NONE";
		manufacturer = "NONE";
		expirationDate = "-1";
		quantity = -1;
		unit = "-1";
	}
	
	/**
	 * Used to get the name of the drug, composed of 2-25
	 * characters including a-z, spaces, dashes, and apostrophes
	 * 
	 * @return A String containing the name of the drug
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Used to set the name of the drug, composed of 2-25 characters that include
	 * a-z, dashes, hyphens, and spaces.
	 * 
	 * @param name A String containing the name of the medicine
	 * @return A true/false that specifies whether the value was correct and stored, or not
	 */
	
	public boolean setName(String name) {
		if ( name == null )
			return false;
		
		name = name.trim().replaceAll(" +", " ");
		
		if ( name.length() < 2 || name.length() > 25 )
			return false;
		
		if ( !name.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.name = name;
		return true;
	}
	
	/**
	 * Used to get the name of the manufacturer.
	 * 
	 * @return A String containing the name of the manufacturer
	 */
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * Used to set the name of the manufacturer, composed of 2-25 characters including
	 * a-z, dashes, hyphens, and spaces.
	 * 
	 * @param manufacturer A String containing the name of the manufacturer.
	 * @return A true/false that specifies whether the value was correct and stored, or not
	 */
	
	public boolean setManufacturer(String manufacturer) {
		if ( manufacturer == null )
			return false;
		
		manufacturer = manufacturer.trim().replaceAll(" +", " ");
		
		if ( manufacturer.length() < 2 || manufacturer.length() > 25 )
			return false;
		
		if ( !manufacturer.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.manufacturer = manufacturer;
		return true;
	}
	
	/**
	 * Used to get the expiration date of the medicine.
	 * 
	 * @return A String in the format YYYY-MM-DD
	 */
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * Used to set the expiration date of the medicine, in the format YYYY-MM-DD
	 * 
	 * @param expirationDate A String containing the expiration date of the medicine, in the format YYYY-MM-DD
	 * @return A true/false that specifies whether the value was correct and stored, or not
	 */
	
	public boolean setExpirationDate(String expirationDate) {
		if ( expirationDate == null )
			return false;
		
		expirationDate = expirationDate.trim().replaceAll(" +", " ");
		
		if ( !expirationDate.matches("\\d{4}-\\d{2}-\\d{2}") )
			return false;
		
		int year = Integer.parseInt(expirationDate.split("-")[0]);
		int month = Integer.parseInt(expirationDate.split("-")[1]);
		int day = Integer.parseInt(expirationDate.split("-")[2]);
		
		LocalDate today = LocalDate.now();
		LocalDate expDate = LocalDate.of(year, month, day);
		
		if ( expDate.isAfter(today.plusDays(7)) ) {
			this.expirationDate = expirationDate;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Used to get the quantity of units included in the container
	 * 
	 * @return An integer representing the quantity of units present in the container
	 */
	
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Used to set the quantity of units in the container.
	 * 
	 * @param quantity An integer that contains a value of 1 or more
	 * @return A true/false that specifies whether the value was correct and stored, or not
	 */
	
	public boolean setQuantity(int quantity) {
		if ( quantity < 1 )
			return false;
		
		this.quantity = quantity;
		return true;
	}
	
	/**
	 * Used to get the type of units that make up the container.
	 * The options are milliliters, grams, or capsules.
	 * 
	 * @return A String that contains the type of unit of the container
	 */
	
	public String getUnit() {
		return unit;
	}
	
	/**
	 * Used to set the units that make up the container. The options are
	 * milliliters, grams, and capsules.
	 * 
	 * @param unit A String that specifies the unit type of the container
	 * @return A true/false that specifies whether the value was correct and stored, or not
	 */
	
	public boolean setUnit(String unit) {
		if ( unit == null )
			return false;
		
		unit = unit.trim().replaceAll(" +", " ");
		
		for ( String target : ACCEPTABLE_UNITS ) {
			if ( target.equalsIgnoreCase(unit) ) {
				this.unit = target;
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		String toReturn = getName() + ", manufactured by " + getManufacturer();
		toReturn += "\nExpiration date: " + getExpirationDate();
		toReturn += "\nEach container contains " + getQuantity() + " " + getUnit() + " of product";
		return toReturn;
	}
}
