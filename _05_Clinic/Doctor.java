package code_uz._05_Clinic;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Doctor extends Person {
	private String speciality;
	private int id;
	private LinkedList patients = new LinkedList();

	public Doctor(String first, String last, String SSN, String speciality) {
		super(first, last, SSN);
		this.speciality = speciality;
	}


	public int getId(){
		return id;
	}
	
	public String getSpecialization(){
		return speciality;
	}
	
	public Collection<Person> getPatients() {
		return patients;
	}

	public void addPatient(Person patient){
		patients.add(patient);
	}

}
