package models;

public class Patient extends Person{
    private String patientId;

    public Patient(String name, int age, String gender, String ContactNumber, String patientId){
        super(name, age, gender, ContactNumber);
        this.patientId = patientId;
    }   


    public String getPatientId() { return patientId; }

    public void setPatientId(String patientId) { this.patientId = patientId; }

    @Override
    public void displayInfo(){
        System.out.println("[Patient Information]:");
        System.out.println("    Patient ID: " + patientId);
        System.out.println("    Name: " + getName());
        System.out.println("    Age: " + getAge());
        System.out.println("    Gender: " + getGender());
        System.out.println("    Contact Number: " + getContactNumber());
    }
    
}
