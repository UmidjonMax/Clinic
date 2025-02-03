package code_uz._05_Clinic;

import java.io.IOException;
import java.util.*;

public class Clinic {
	Map<String, Person> patients = new HashMap<>();
	Map<Integer, Doctor> doctors = new HashMap<>();

	public void addPatient(String firstName, String lastName, String ssn) {
		Person patient = new Person(firstName, lastName);
		patients.put(ssn, patient);
	}

	public void addDoctor(String firstName, String lastName, String ssn, int docID, String specialization) {
		Doctor doctor = new Doctor(firstName, lastName, ssn, specialization);
		doctors.put(docID, doctor);
	}

	public Person getPatient(String ssn) throws NoSuchPatient {
		if (patients.containsKey(ssn)) {
			return patients.get(ssn);
		}
		throw new NoSuchPatient();
	}

	public Doctor getDoctor(int docID) throws NoSuchDoctor {
		if (doctors.containsKey(docID)) {
			return doctors.get(docID);
		}
		throw new NoSuchDoctor();
	}
	
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		Person patient = patients.get(ssn);
		Doctor doctor = doctors.get(docID);
		if (patient == null){
			throw new NoSuchPatient();
		}
		if (doctor == null){
			throw new NoSuchDoctor();
		}
		doctor.addPatient(patient);
		patient.setDoctor(doctor);
	}

	Collection<Doctor> idleDoctors(){
		LinkedList<Doctor> idleDoctors = new LinkedList<>();
		for (Doctor value : doctors.values()) {
			if (value.getPatients().isEmpty()) {
				idleDoctors.add(value);
			}
		}
		Collections.sort(idleDoctors);
		return idleDoctors;
	}

	Collection<Doctor> busyDoctors(){
		LinkedList<Doctor> busyDoctors = new LinkedList<>();
		for (Doctor value : doctors.values()) {
			if (value.getPatients().size()>=(doctors.size()/patients.size())) {
				busyDoctors.add(value);
			}
		}
		busyDoctors.sort((d1, d2) -> d1.getFirst().compareTo(d2.getFirst()));
		return busyDoctors;
	}

	Collection<String> doctorsByNumPatients(){
		LinkedList<Doctor> doctorsByNumPatients = new LinkedList<>();
        doctorsByNumPatients.addAll(this.doctors.values());
		Collections.sort(doctorsByNumPatients, new Comparator<Doctor>() {
			@Override
			public int compare(Doctor d1, Doctor d2) {
				int result = d2.getPatients().size()-d1.getPatients().size();
				if (result == 0) {
					return d1.getFirst().compareTo(d2.getFirst());
				}
				return result;
			}
		});
		List<String> doctorsByNumPatientsString = new ArrayList<>();
		for (Doctor doctor : doctorsByNumPatients) {
			String s = "  "+doctor.getPatients().size() + ": " +  doctor.getFirst() + " " + doctor.getLast();
			doctorsByNumPatientsString.add(s);
		}

		return doctorsByNumPatientsString;
	}

	public Collection<String> countPatientsPerSpecialization(){
		LinkedList<SpecPatientCount> specPatientCounts = new LinkedList<>();
		for (Doctor doctor : doctors.values()) {
			specPatientCounts.add(new SpecPatientCount(doctor.getPatients().size(), doctor.getSpecialization()));
		}
		Collections.sort(specPatientCounts);
		LinkedList<String> specPatientCountsString = new LinkedList<>();
		for (SpecPatientCount specPatientCount : specPatientCounts) {
			String s = "  "+ specPatientCount.getPatientCount() + " " + specPatientCount.getSpecName();
			specPatientCountsString.add(s);
		}
		return specPatientCountsString;
	}
	
	public void loadData(String path) throws IOException {
		
	}


}
