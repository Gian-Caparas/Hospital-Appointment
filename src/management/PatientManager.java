package management;

import models.Patient;
import models.MedicalRecord;
import java.util.ArrayList;

public class PatientManager {
    
    private ArrayList<Patient> patients;
    private int counter = 1; 

    public PatientManager() {
        this.patients = new ArrayList<>();
    }

    
    public void addPatient(String name, int age, String gender, String contact) {
        
        String id = "P00" + counter; 
        counter++;
        
        Patient newPatient = new Patient(name, age, gender, contact, id);
        patients.add(newPatient);
        System.out.println("Patient added: " + name + " (ID: " + id + ")");
    }

    
    public Patient searchPatientById(String id) {
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            if (p.getPatientId().equals(id)) {
                return p;
            }
        }
        return null; 
    }

    
    public void updatePatient(String id, String field, String value) {
        Patient p = searchPatientById(id);
        if (p != null) {
            if (field.equalsIgnoreCase("contact")) {
                p.setContactNumber(value);
                System.out.println("Contact updated for " + id);
            }
        } else {
            System.out.println("Patient not found!");
        }
    }

    
    public void linkMedicalRecord(String id, MedicalRecord record) {
        Patient p = searchPatientById(id);
        if (p != null) {
            p.setMedicalRecord(record); 
            System.out.println("Medical Record linked to " + id);
        }
    }

    
    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
