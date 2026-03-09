package management;

import models.Patient;
import java.util.ArrayList;
import java.util.List;
public class PatientManager {
    private ArrayList<Patient> patients;
    private int idCounter;    

    public PatientManager() {
        this.patients = new ArrayList<>();
        this.idCounter = 1;
    }
    
    public Patient addPatient(String name, int age, String gender, String contact) {
        String patientId = "P" + String.format("%03d", idCounter++);
        Patient patient = new Patient(name, age, gender, contact, patientId);
        patients.add(patient);
        return patient;
    }

    // Convenience overload used by the booking flow when optional details are not collected.
    public Patient addPatient(String name, int age) {
        return addPatient(name, age, "Not Specified", "N/A");
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

    public List<Patient> getPatients() { return patients; }
    
    public void listPatients() {
        if (patients.isEmpty()) {
            System.out.println("  No patients registered.");
            return;
        }
        System.out.println("\n  ===== Registered Patients =====");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("  -------------------------------");
        }
    }
}
