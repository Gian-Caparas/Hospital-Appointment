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

    // Convenience overload used by seed data when only core doctor fields are provided.
    public Doctor(String name, int age, String doctorId, String department) {
        this(doctorId, name, age, "Not Specified", "N/A", department, department);
    }

    
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getSpecialization() {return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getDepartment() {return department; }
    public void setDepartment(String department) { this.department = department; }
    
     //You can change the displayInfo if di ing ani ang gusto sa display dude
    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId + " | Name: " + getName() + " | Specialty: " + specialization);
        System.out.println("  [Doctor Information]:");
        System.out.println("  Doctor ID  : " + doctorId);
        System.out.println("  Name       : " + getName());
        System.out.println("  Department : " + department);
        System.out.println("  Age        : " + getAge());
        System.out.println("  Specialty  : " + specialization);
        System.out.println("  Contact    : " + getContactNumber());
    }
}