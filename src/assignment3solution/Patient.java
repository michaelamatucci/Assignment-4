package assignment3solution;

/*
 * Taken from assignment 2 solution
 * Modified 2020-04-16 by Michael Amatucci
 */

public class Patient extends Person {
	private String primaryPhysician;
	private String notes;
	
	//constructor
	public Patient()
	{
		super();
		primaryPhysician = "NONE";
		notes = "NONE";
	}
	
	public String getPrimaryPhysician() {
		return primaryPhysician;
	}
	
	public boolean setPrimaryPhysician(String primaryPhysician, Person people[]) {
		if ( primaryPhysician == null )
			return false;
		
		primaryPhysician = primaryPhysician.trim().replaceAll(" +", " ");
		
		// Since the person's name is between 2 and 20 characters, the first
		// and last name would be between (2 + 1 + 2) and (20 + 1 + 20), where
		// the 1 represents a space separating first and last name.
		if ( primaryPhysician.length() < 5 || primaryPhysician.length() > 41 )
			return false;
		
		if ( !primaryPhysician.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		//Checks if the array of People objects contains the physician with a matching ID
		
		if(people != null)
		{
			boolean contains = false;
			
			for(Person p : people)
			{
				if(p instanceof Doctor)
				{
					String empName = p.getFirstName();
					empName += " " + p.getLastName();
					
					if(empName.equalsIgnoreCase(primaryPhysician))
						contains = true;
				}
			}
			
			if(!contains)
			{
				this.primaryPhysician = "Physician not found";
				return false;
			}
		}
		
		this.primaryPhysician = primaryPhysician;
		return true;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public boolean setNotes(String notes) {
		if ( notes == null )
			return false;
		
		notes = notes.trim().replaceAll(" +", " ");
		
		if ( notes.length() < 2 || notes.length() > 100 )
			return false;
		
		if ( !notes.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.notes = notes;
		return true;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nPrimary Physician: " + getPrimaryPhysician();
		toReturn += "\nNotes: " + getNotes();
		return toReturn;
	}
}
