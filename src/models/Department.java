package models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Doctor> doctors; // The list of doctors assigned to this department

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.doctors = new ArrayList<>(); 
    }

    // Adding a doctor to this specific department
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

   
    public String getDepartmentName() {
        return departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
    
    // It's like a helper who's in the department
    public void displayDepartmentInfo() {
        System.out.println("Department: " + departmentName);
        for (Doctor d : doctors) {
            System.out.println(" - " + d.getName());
        }
    }
}