package grsu.course.app.entity;

import java.time.LocalDate;

public class Appointment {
    private String cause;
    private String timeOfApp;
    private LocalDate dateOfApp;
    private Patient patient;

    public Appointment(LocalDate dateOfApp, String timeOfApp, String cause, Patient patient) {
        this.dateOfApp = dateOfApp;
        this.timeOfApp = timeOfApp;
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
                ", dateOfApp=" + dateOfApp +
                ", patient=" + patient +
                '}';
    }
}
