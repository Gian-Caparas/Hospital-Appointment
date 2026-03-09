package models;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date){
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getDate() { return date; }

    public void displayAppointment() {
        System.out.println("\n  =========================================");
        System.out.println("           APPOINTMENT DETAILS            ");
        System.out.println("  =========================================");
        patient.displayInfo();
        System.out.println("  -----------------------------------------");
        doctor.displayInfo();
        System.out.println("  Date       : " + date);
        System.out.println("  =========================================");
    }

        public String toFileString() {
        return "==========================================\n"
             + "         APPOINTMENT RECORD               \n"
             + "==========================================\n"
             + "Date         : " + date + "\n"
             + "Patient ID   : " + patient.getPatientId() + "\n"
             + "Patient Name : " + patient.getName() + "\n"
             + "Patient Age  : " + patient.getAge() + "\n"
             + "------------------------------------------\n"
             + "Doctor ID    : " + doctor.getDoctorId() + "\n"
             + "Doctor Name  : " + doctor.getName() + "\n"
             + "Department   : " + doctor.getDepartment() + "\n"
             + "==========================================\n";
    }

}
