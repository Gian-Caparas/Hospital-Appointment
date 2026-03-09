package management;

import models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorManager {
   // Array of all doctors
    private List<Doctor> doctors;

    public DoctorManager() {
        this.doctors = new ArrayList<>();
    }

    //  Registers a doctor into DoctorManager
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    //It returns the full arrayList of all doctors 
    public List<Doctor> getDoctors() { return doctors; }

    //Assigns time slots to a doctor's Schedule
    public void listDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("  No doctors registered.");
            return;
        }
        System.out.println("\n  ===== Registered Doctors =====");
        for (Doctor d : doctors) {
            d.displayInfo();
            System.out.println("  ------------------------------");
        }
    }
}