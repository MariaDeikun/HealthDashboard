package grsu.course.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class EmptyAppointment {
    private String cause;
    private String timeOfApp;
    private LocalDate dateOfApp;

    public EmptyAppointment () {}

    public EmptyAppointment(LocalDate dateOfApp, String timeOfApp, String cause) {
        this.dateOfApp = dateOfApp;
        this.timeOfApp = timeOfApp;
        this.cause = cause;
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


    @Override
    public String toString() {
        return "Appointment{" +
                "cause='" + cause + '\'' +
                ", timeOfApp='" + timeOfApp + '\'' +
                ", dateOfApp=" + dateOfApp +
                '}';
    }
}
