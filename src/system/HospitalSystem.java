package system;

import management.AppointmentManager;
import management.DepartmentManager;
import management.DoctorManager;
import management.PatientManager;
import models.Appointment;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;
import utils.FileManager;

import java.util.List;
import java.util.Scanner;

public class HospitalSystem {

    // ── Managers (Member responsibilities split here) ─────────────────────
    private static PatientManager    patientManager    = new PatientManager();
    private static DoctorManager     doctorManager     = new DoctorManager();
    private static DepartmentManager departmentManager = new DepartmentManager();
    private static AppointmentManager appointmentManager = new AppointmentManager();
    private static Hospital hospital = new Hospital("CIT-U Wildcats Hospital");
    private static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        runSystem();
    }

    // ── Seed default doctors and departments ──────────────────────────────
    private static void seedData() {
        // Cardiology
        Department cardiology = departmentManager.createDepartment("Cardiology");
        Doctor d1 = new Doctor("Dr. Smith",  45, "D001", "Cardiology");
        Doctor d2 = new Doctor("Dr. Reyes",  39, "D002", "Cardiology");
        cardiology.addDoctor(d1);
        cardiology.addDoctor(d2);
        doctorManager.addDoctor(d1);
        doctorManager.addDoctor(d2);

        // Pediatrics
        Department pediatrics = departmentManager.createDepartment("Pediatrics");
        Doctor d3 = new Doctor("Dr. Johnson", 38, "D003", "Pediatrics");
        Doctor d4 = new Doctor("Dr. Cruz",    42, "D004", "Pediatrics");
        pediatrics.addDoctor(d3);
        pediatrics.addDoctor(d4);
        doctorManager.addDoctor(d3);
        doctorManager.addDoctor(d4);

        // Neurology
        Department neurology = departmentManager.createDepartment("Neurology");
        Doctor d5 = new Doctor("Dr. Martinez", 50, "D005", "Neurology");
        Doctor d6 = new Doctor("Dr. Santos",   44, "D006", "Neurology");
        neurology.addDoctor(d5);
        neurology.addDoctor(d6);
        doctorManager.addDoctor(d5);
        doctorManager.addDoctor(d6);

        // Orthopedics
        Department orthopedics = departmentManager.createDepartment("Orthopedics");
        Doctor d7 = new Doctor("Dr. Lee",   47, "D007", "Orthopedics");
        Doctor d8 = new Doctor("Dr. Gomez", 36, "D008", "Orthopedics");
        orthopedics.addDoctor(d7);
        orthopedics.addDoctor(d8);
        doctorManager.addDoctor(d7);
        doctorManager.addDoctor(d8);

        // Dermatology
        Department dermatology = departmentManager.createDepartment("Dermatology");
        Doctor d9  = new Doctor("Dr. Park",  33, "D009", "Dermatology");
        Doctor d10 = new Doctor("Dr. Lim",   41, "D010", "Dermatology");
        dermatology.addDoctor(d9);
        dermatology.addDoctor(d10);
        doctorManager.addDoctor(d9);
        doctorManager.addDoctor(d10);
    }

    // ── Main system loop ──────────────────────────────────────────────────
    public static void runSystem() {
        hospital.displayHospital();

        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    bookAppointment();
                    break;
                case "2":
                    appointmentManager.listAppointments();
                    break;
                case "3":
                    patientManager.listPatients();
                    break;
                case "4":
                    doctorManager.listDoctors();
                    break;
                case "5":
                    running = false;
                    System.out.println("\n  Thank you for using the Hospital Appointment System.");
                    System.out.println("  Goodbye! Stay healthy!\n");
                    break;
                default:
                    System.out.println("\n  [!] Invalid option. Please choose 1 to 5.");
            }
        }

        scanner.close();
    }

    // ── Menu ──────────────────────────────────────────────────────────────
    private static void printMainMenu() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║              MAIN MENU                   ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1. Book an Appointment                  ║");
        System.out.println("║  2. View All Appointments                ║");
        System.out.println("║  3. View All Patients                    ║");
        System.out.println("║  4. View All Doctors                     ║");
        System.out.println("║  5. Exit                                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("  Select option: ");
    }

    // ── Book appointment flow ─────────────────────────────────────────────
    private static void bookAppointment() {
        System.out.println("\n  ===== Book an Appointment =====");

        // Step 1: Patient info
        System.out.print("  Enter Patient Name : ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("  [!] Name cannot be empty.");
            return;
        }

        System.out.print("  Enter Age          : ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
            if (age <= 0 || age > 120) {
                System.out.println("  [!] Please enter a valid age (1-120).");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("  [!] Invalid age. Please enter a number.");
            return;
        }

        System.out.print("  Enter Patient Gender : ");
        String gender = scanner.nextLine().trim();
        if (gender.isEmpty()) {
            gender = "Not Specified";
        }

        System.out.print("  Enter Contact Number : ");
        String contact = scanner.nextLine().trim();
        if (contact.isEmpty()) {
            contact = "N/A";
        }

        Patient patient = patientManager.addPatient(name, age, gender, contact);
        System.out.println("  Patient registered: " + patient.getPatientId());

        // Step 2: Choose department
        departmentManager.listDepartments();
        List<Department> departments = departmentManager.getDepartments();
        System.out.print("  Select Department (1-" + departments.size() + "): ");

        int deptChoice;
        try {
            deptChoice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  [!] Invalid input.");
            return;
        }

        Department selectedDept = departmentManager.getDepartmentByIndex(deptChoice - 1);
        if (selectedDept == null) {
            System.out.println("  [!] Department not found.");
            return;
        }

        // Step 3: Choose doctor within department
        List<Doctor> doctors = selectedDept.getDoctors();
        System.out.println("\n  Doctors in " + selectedDept.getDepartmentName() + ":");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println("  " + (i + 1) + " - " + doctors.get(i).getName());
        }
        System.out.print("  Select Doctor (1-" + doctors.size() + "): ");

        int docChoice;
        try {
            docChoice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  [!] Invalid input.");
            return;
        }

        if (docChoice < 1 || docChoice > doctors.size()) {
            System.out.println("  [!] Doctor not found.");
            return;
        }

        Doctor assignedDoctor = doctors.get(docChoice - 1);

        // Step 4: Create appointment
        System.out.println("\n  Assigning Doctor...");
        System.out.println("  Doctor Assigned: " + assignedDoctor.getName());

        Appointment appointment = appointmentManager.createAppointment(patient, assignedDoctor);
        System.out.println("  Appointment Created Successfully.");

        appointment.displayAppointment();

        // Step 5: Save to file
        FileManager.saveAppointmentToFile(appointment);
    }
}