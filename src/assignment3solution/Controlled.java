package assignment3solution;

/*
 * Taken from assignment 2 solution
 * Modified 2020-03-30 by Michael Amatucci
 */

public class Controlled extends OTCDrug {
	private boolean requiresID;
	private boolean requiresSignature;
	
	//constructor
	public Controlled()
	{
		super();
		requiresID = false;
		requiresSignature = false;
	}

	public boolean requiresID() {
		return requiresID;
	}
	
	public void setRequiresID(boolean requiresID) {
		this.requiresID = requiresID;
		
		// Since a controlled OTC drug requires either a signature
		// or an ID, if we set one to false we should automatically
		// set the other to true.
		
		if ( !requiresID )
			setRequiresSignature(true);
	}
	
	public boolean requiresSignature() {
		return requiresSignature;
	}
	
	public void setRequiresSignature(boolean requiresSignature) {
		this.requiresSignature = requiresSignature;
		
		// Since a controlled OTC drug requires either a signature
		// or an ID, if we set one to false we should automatically
		// set the other to true.
		
		if ( !requiresSignature ) {
			setRequiresID(true);
		}
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nThe patient " + (requiresID()?"needs":"does not need") + " to show an ID";
		toReturn += "\nThe patient " + (requiresSignature()?"needs":"does not need") + " to sign for this drug";
		return toReturn;
	}
}
