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

    public void displayAppointment(){
        System.out.println("===== Appointment Details: ====="); //kailangan pa og design?
        System.out.println("Patient: " + patient.getName()); //Name ra i-display?
        //patient.displayInfo(); // OR kania gamiton? like para display ang whole info sa patient.
        System.out.println("Doctor-in-charge: " + doctor.getName()); // If mag getName sa doctor, dapat mag add og getName method sa Doctor class
        System.out.println("Date: " + date);
    }



    /* In case mag need  // Delete if not needed
    
    Getters and setters 

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    */


}
