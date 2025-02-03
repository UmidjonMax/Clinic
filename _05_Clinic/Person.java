package code_uz._05_Clinic;


public class Person implements Comparable<Person>{
	@Override
	public int compareTo(Person o) {
		int result = this.last.compareTo(o.last);
		if (result == 0){
			result = this.first.compareTo(o.first);
		}
		return result;
	}

	private String first;
	private String last;
	private String SSN;
	private Doctor doctor;

	public Person(String first, String last) {
		this.first = first;
		this.last = last;
	}
	public Person(String first, String last, String SSN) {
		this.first = first;
		this.last = last;
		this.SSN = SSN;
	}

	public String getSSN(){
		return SSN;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

}
