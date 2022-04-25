package grsu.course.app.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Appointment extends EmptyAppointment{
    private String cause;
    private String timeOfApp;
    private LocalDate dateOfApp;
    private Patient patient;

    public Appointment () {}

    public Appointment(LocalDate dateOfApp, String timeOfApp, String cause, Patient patient) {
        super(dateOfApp, timeOfApp, cause);
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate getDateOfApp() {
        return dateOfApp;
    }

    @JsonSerialize(using = LocalDateSerializer.class)
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
