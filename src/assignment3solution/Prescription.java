package assignment3solution;

/*
 * Taken from assignment 2 solution
 * Modified 2020-04-20 by Michael Amatucci
 * Modified 04-18-2020 by Victoria McNally
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
	
	public boolean setPrescriberID(String prescriberID, Person people[]) {
		
		if ( prescriberID == null )
			return false;
		
		prescriberID = prescriberID.trim().replaceAll(" ", "");
		
		//checks the prescriber ID against the array of people to find a matching Doctor or prescriber Nurse
		
		if(people != null)
		{
			boolean contains = false;
			
			for(Person p : people)
			{
				if(p instanceof Doctor)
				{
					String empId = ((Doctor) p).getEmployeeID();
					
					if(empId.equalsIgnoreCase(prescriberID))
						contains = true;
				}
				else if(p instanceof Nurse)
				{
					String empId = ((Nurse) p).getEmployeeID();
					
					if(empId.equalsIgnoreCase(prescriberID) && ((Nurse) p).canPrescribe())
						contains = true;
				}
			}
			
			if(!contains)
			{
				this.prescriberID = "Prescriber not found";
				return false;
			}
		}
		
		
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
