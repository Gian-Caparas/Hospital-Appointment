package models;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private String Diagnosis;
    private String Prescription;
    private List<String> visitHistory;

    public MedicalRecord(){
        this.Diagnosis = "No diagnosis yet";
        this.Prescription = "No prescription yet";
        this.visitHistory = new ArrayList<>();
    }

    public String getDiagnosis() {
        return Diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public String getPrescription() {
        return Prescription;
    }
    public void setPrescription(String prescription) {
        Prescription = prescription;
    }

    public List<String> getVisitHistory() {
        return visitHistory;
    }
    public void setVisitHistory(List<String> visitHistory) {
        this.visitHistory = visitHistory;
    }


}
