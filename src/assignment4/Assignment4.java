package assignment4;

import java.util.Scanner;

import assignment3solution.Controlled;
import assignment3solution.Doctor;
import assignment3solution.Employee;
import assignment3solution.Medicine;
import assignment3solution.Nurse;
import assignment3solution.OTCDrug;
import assignment3solution.Patient;
import assignment3solution.Person;
import assignment3solution.Prescription;

/*
 * Using Assignment 2 & 3 solutions
 * 
 * Modified by Michael Amatucci
 */

public class Assignment4 {

	public static void main(String[] args) {
		System.out.println("Assignment 3");
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please choose which type of object you'd like to create.");
		System.out.println("1) Person\n2) Employee\n3) Doctor\n4) Nurse\n5) Patient");
		System.out.println("6) Medicine\n7) OTC Drug\n8) Controlled OTC Drug\n9) Prescription");
		
		System.out.print("Choice: ");
		int choice = Integer.parseInt(userInput.nextLine());
		System.out.println("-------------------");
		
		switch(choice) {
		case 1: // Person
			Person p = new Person();
			getPersonInformation(p, userInput);
			System.out.println("-------------------");
			System.out.println(p);
			break;
		case 2: // Employee
			Employee e = new Employee();
			getEmployeeInformation(e, userInput);
			System.out.println("-------------------");
			System.out.println(e);
			break;
		case 3: // Doctor
			Doctor d = new Doctor();
			getDoctorInformation(d, userInput);
			System.out.println("-------------------");
			System.out.println(d);
			break;
		case 4: // Nurse
			Nurse n = new Nurse();
			getNurseInformation(n, userInput);
			System.out.println("-------------------");
			System.out.println(n);
			break;
		case 5: // Patient
			Patient pt = new Patient();
			getPatientInformation(pt, userInput);
			System.out.println("-------------------");
			System.out.println(pt);
			break;
		case 6: // Medicine
			Medicine m = new Medicine();
			getMedicineInformation(m, userInput);
			System.out.println("-------------------");
			System.out.println(m);
			break;
		case 7: // OTC Drug
			OTCDrug otc = new OTCDrug();
			getOTCDrugInformation(otc, userInput);
			System.out.println("-------------------");
			System.out.println(otc);
			break;
		case 8: // Controlled drug
			Controlled cd = new Controlled();
			getControlledInformation(cd, userInput);
			System.out.println("-------------------");
			System.out.println(cd);
			break;
		case 9: // Prescription
			Prescription pd = new Prescription();
			getPrescriptionInformation(pd, userInput);
			System.out.println("-------------------");
			System.out.println(pd);
			break;
		default:
			System.out.println("The input is not valid.");
		}
		
		userInput.close();
	}
	
	public static void getPrescriptionInformation(Prescription p, Scanner userInput) {
		getMedicineInformation(p, userInput);
		
		System.out.print("7-digit ID of the prescription: ");
		p.setPrescriptionID(userInput.nextLine());
		
		System.out.print("10-digit ID of the prescriber: ");
		p.setPrescriberID(userInput.nextLine());
	}
	
	public static void getControlledInformation(Controlled c, Scanner userInput) {
		getOTCDrugInformation(c, userInput);
		
		System.out.print("The patient needs to show an ID to purchase this drug (y-yes, n-no): ");
		
		char choice = 'n';
		String input = userInput.nextLine().toLowerCase();
		if(input.isEmpty() == false)
			choice = input.charAt(0);
		
		if ( choice == 'y' )
			c.setRequiresID(true);
		else
			c.setRequiresID(false);
		
		System.out.print("The patient needs to sign to purchase this drug (y-yes, n-no): ");
		
		choice = 'n';
		input = userInput.nextLine().toLowerCase();
		
		if(input.isEmpty() == false)
			choice = input.charAt(0);
		
		if ( choice == 'y' )
			c.setRequiresSignature(true);
		else
			c.setRequiresSignature(false);
	}
	
	public static void getOTCDrugInformation(OTCDrug o, Scanner userInput) {
		getMedicineInformation(o, userInput);
		
		System.out.print("Enter the cost of the drug in dollars: ");
		String input = userInput.nextLine();
		
		if(input.isEmpty() == false)
			o.setCost(Double.parseDouble(input));
		
		System.out.print("Enter the composition of the drug, 100 characters max: ");
		o.setComposition(userInput.nextLine());
	}
	
	public static void getMedicineInformation(Medicine m, Scanner userInput) {
		System.out.print("Enter the name of the medicine (2-25 characters): ");
		m.setName(userInput.nextLine());
		
		System.out.print("Enter the manufacturer of the medicine (2-25 characters): ");
		m.setManufacturer(userInput.nextLine());
		
		System.out.print("Enter the expiration date using format YYYY-MM-DD: ");
		m.setExpirationDate(userInput.nextLine());
		
		System.out.print("Enter the quantity of medicine in the container (1+): ");
		String input = userInput.nextLine();
		
		if(input.isEmpty() == false)
			m.setQuantity(Integer.parseInt(input));
		
		System.out.print("Enter the unit of the container (milliliters, grams, or capsules): ");
		m.setUnit(userInput.nextLine());
	}
	
	public static void getPatientInformation(Patient p, Scanner userInput) {
		getPersonInformation(p, userInput);
		
		System.out.print("Enter the name of the primary physician: ");
		p.setPrimaryPhysician(userInput.nextLine());
		
		System.out.print("Enter any notes about the patient, max 100 characters: ");
		p.setNotes(userInput.nextLine());
	}
	
	public static void getNurseInformation(Nurse n, Scanner userInput) {
		getEmployeeInformation(n, userInput);
		
		System.out.print("Enter the nurse's department: ");
		n.setDepartment(userInput.nextLine());
		
		System.out.print("This nurse can prescribe medications (y-yes, n-no): ");
		char choice = 'n';
		String input = userInput.nextLine().toLowerCase();
		if(input.isEmpty() == false)
			choice = input.charAt(0);
		
		if ( choice == 'y' )
			n.setCanPrescribe(true);
		else
			n.setCanPrescribe(false);
	}
	
	public static void getDoctorInformation(Doctor d, Scanner userInput) {
		getEmployeeInformation(d, userInput);
		
		System.out.print("Enter the doctor's specialty: ");
		d.setSpecialty(userInput.nextLine());
		System.out.print("This doctor can perform surgery (y-yes, n-no): ");
		char choice = 'n';
		String input = userInput.nextLine().toLowerCase();
		if(input.isEmpty() == false)
			choice = input.charAt(0);
		
		if ( choice == 'y')
			d.setCanOperate(true);
		else
			d.setCanOperate(false);
	}
	
	public static void getEmployeeInformation(Employee e, Scanner userInput) {
		getPersonInformation(e, userInput);
		
		System.out.print("Enter the 10-digit employee ID: ");
		e.setEmployeeID(userInput.nextLine());
		
		System.out.print("Enter the hire date (YYYY-MM-DD): ");
		e.setHireDate(userInput.nextLine());
	}
	
	public static void getPersonInformation(Person p, Scanner userInput) {
		System.out.print("Enter the first name (2-20 characters): ");
		p.setFirstName(userInput.nextLine());
		
		System.out.print("Enter the last name (2-20 characters): ");
		p.setLastName(userInput.nextLine());
		
		System.out.print("Enter the date of birth in the format YYYY-MM-DD: ");
		p.setDateOfBirth(userInput.nextLine());
	}
}
