package grsu.course.app.entity;

import java.time.LocalDate;

public class AppointmentForDr extends Appointment{

    private String doctor;
    public AppointmentForDr(LocalDate dateOfApp, String timeOfApp, String cause, String doctor, Patient patient) {
        super(dateOfApp, timeOfApp, cause, patient);
        this.doctor=doctor;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

}
