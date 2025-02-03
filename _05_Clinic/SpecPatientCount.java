package code_uz._05_Clinic;

public class SpecPatientCount implements Comparable<SpecPatientCount>{
    private String specName;
    private int patientCount;

    public SpecPatientCount(int patientCount, String specName) {
        this.specName = specName;
        this.patientCount = patientCount;
    }

    public String getSpecName() {
        return specName;
    }

    public int getPatientCount() {
        return patientCount;
    }

    @Override
    public int compareTo(SpecPatientCount o) {
        int result = o.patientCount - this.patientCount;
        if (result == 0){
            return this.specName.compareTo(o.specName);
        }
        return result;
    }
}
