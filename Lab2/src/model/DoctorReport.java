package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorReport {
    private String patientName;
    private String placeOfResidence;
    private Date dateOfBirth;
    private Date dateOfReceipt;
    private String doctorName;
    private String conclusion;

    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getPatientName() {
        return patientName;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public String getPlaceOfResidence() { return placeOfResidence; }

    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth;}

    public String getDateOfBirth() { return String.valueOf(dateOfBirth); }

    public void setDateOfReceipt(Date dateOfReceipt)  { this.dateOfReceipt = dateOfReceipt; }

    public String getDateOfReceipt() { return String.valueOf(dateOfReceipt); }

    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getDoctorName() { return doctorName; }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getConclusion() {
        return conclusion;
    }




}
