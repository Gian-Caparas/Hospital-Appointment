package models;

// Doctor Class inherits from Person
public class Doctor extends Person {
    private String doctorId; 
    private String specialization; 
    private String department;

    public Doctor(String doctorId, String name, int age, String gender, String contactNumber, String specialization, String department) {
        super(name, age, gender, contactNumber);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.department = department;
    }

    
    public String getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getDepartment() {
        return department;
    }
     //You can change the displayInfo if di ing ani ang gusto sa display dude
    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId + " | Name: " + getName() + " | Specialty: " + specialization);
    }
}