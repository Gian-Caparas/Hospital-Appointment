package management;

import java.util.ArrayList;
import java.util.List;

import models.Appointment;

public class AppointmentManager {
    //Creates List of Appointments and calls it appointments
    private List<Appointment> appointments = new ArrayList<>();

    public void createAppointment(Appointment a){ //stores the variable parameter(calls it "a") in the list of appointments.
        appointments.add(a); //adds the appointment(variable "a") to the list of Variable "appointments"
    }

    public void listAppointments(){
        for(Appointment a : appointments){//for each appointment(calls it "a") in the list of appointments, it will loop through untl it reaches the end of the list
            a.displayAppointment(); //displays the appointment(called variable "a") details by calling the displayAppointment method in the Appointment class using the variable "a" which represents each appointment in the list.
        }
    }

}
