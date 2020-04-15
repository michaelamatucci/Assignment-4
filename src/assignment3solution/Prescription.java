package assignment3solution;

/*
 * Taken from assignment 2 solution
 * Modified 2020-04-04 by Michael Amatucci
 */

public class Prescription extends Medicine {
	private String prescriptionID;
	private String prescriberID;
	
	//constructor
	public Prescription()
	{
		super();
		prescriptionID = "-1";
		prescriberID = "-1";
	}
	
	public String getPrescriptionID() {
		return prescriptionID;
	}
	
	public boolean setPrescriptionID(String prescriptionID) {
		if ( prescriptionID == null )
			return false;
		
		prescriptionID = prescriptionID.trim().replaceAll(" ", "");
		
		if ( !prescriptionID.matches("\\d{7}") )
			return false;
		
		this.prescriptionID = prescriptionID;
		return true;
	}
	
	public String getPrescriberID() {
		return prescriberID;
	}
	
	public boolean setPrescriberID(String prescriberID) {
		if ( prescriberID == null )
			return false;
		
		prescriberID = prescriberID.trim().replaceAll(" ", "");
		
		if ( !prescriberID.matches("\\d{10}") )
			return false;
		
		this.prescriberID = prescriberID;
		return true;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nPrescription ID: " + getPrescriptionID();
		toReturn += "\nID of the prescriber: " + getPrescriberID();
		return toReturn;
	}
}
