package grsu.course.app.entity;

import java.time.LocalDate;

public class Appointment extends Entity {
    private String cause;
    private String timeOfApp;
    private String doctor;
    private LocalDate dateOfApp;
    private Patient patient;

    public Appointment(Integer id, LocalDate dateOfApp, String timeOfApp, String cause, String doctor, Patient patient) {
        super(id);
        this.dateOfApp = dateOfApp;
        this.timeOfApp = timeOfApp;
        this.doctor = doctor;
        this.cause = cause;
        this.patient = patient;
    }
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getTimeOfApp() {
        return timeOfApp;
    }

    public void setTimeOfApp(String timeOfApp) {
        this.timeOfApp = timeOfApp;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDateOfApp() {
        return dateOfApp;
    }

    public void setDateOfApp(LocalDate dateOfApp) {
        this.dateOfApp = dateOfApp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "cause='" + cause + '\'' +
                ", timeOfApp='" + timeOfApp + '\'' +
                ", doctor='" + doctor + '\'' +
                ", dateOfApp=" + dateOfApp +
                ", patient=" + patient +
                '}';
    }
}
