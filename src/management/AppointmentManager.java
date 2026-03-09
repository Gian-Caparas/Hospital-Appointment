package management;

import models.Appointment;
import models.Doctor;
import models.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class AppointmentManager {
    //Creates List of Appointments and calls it appointments
    private final List<Appointment> appointments = new ArrayList<>();

    public Appointment createAppointment(Patient patient, Doctor doctor) {
        String date = LocalDate.now().toString();
        Appointment appointment = new Appointment(patient, doctor, date);
        appointments.add(appointment);
        return appointment;
    }

    public void listAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("\n  No appointments found.");
            return;
        }
        System.out.println("\n  ===== All Appointments (" + appointments.size() + ") =====");
        for (Appointment a : appointments) {
            a.displayAppointment();
        }
    }

    public List<Appointment> getAppointmentList() { return appointments; }
}
