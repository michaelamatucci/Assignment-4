package assignment3solution;

import java.text.DecimalFormat;

/*
 * Taken from assignment 2 solution
 * Modified 2020-03-30 by Michael Amatucci
 */

public class OTCDrug extends Medicine {
	private double cost;
	private String composition;
	
	//constructor
	public OTCDrug()
	{
		super();
		cost = -1;
		composition = "NONE";
	}
	
	public double getCost() {
		return cost;
	}
	
	public boolean setCost(double cost) {
		if ( cost < 0d )
			return false;
		
		this.cost = cost;
		return true;
	}
	
	public String getComposition() {
		return composition;
	}
	
	public boolean setComposition(String composition) {
		if ( composition == null )
			return false;
		
		composition = composition.trim().replaceAll(" +", " ");
		
		if ( composition.length() < 2 || composition.length() > 100 )
			return false;
		
		if ( !composition.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.composition = composition;
		return true;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nCost: $" + new DecimalFormat("#.00").format(getCost());
		toReturn += "\nComposition: " + getComposition();
		return toReturn;
	}
}
