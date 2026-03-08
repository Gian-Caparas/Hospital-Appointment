package management;

import models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorManager {
   // Array of all doctors
    private List<Doctor> doctors = new ArrayList<>();

    //  Registers a doctor into DoctorManager
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    //Assigns time slots to a doctor's Schedule
    public void setSchedule(String doctorId, List<String> slots) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                
                break;
            }
        }
    }

    //It returns the full arrayList of all doctors 
    public List<Doctor> getDoctors() {
        return doctors;
    }
}