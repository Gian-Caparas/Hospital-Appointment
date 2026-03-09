package models;

public class Hospital {
    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public void displayHospital() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.printf( "║  Welcome to %-30s║%n", hospitalName);
        System.out.println("║       Hospital Appointment System        ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}