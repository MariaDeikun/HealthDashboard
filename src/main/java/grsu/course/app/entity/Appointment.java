package grsu.course.app.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import grsu.course.app.controller.CalendarController;
import grsu.course.app.service.IAppointmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Appointment extends EmptyAppointment implements IAppointmentService {
    private static final Logger logger = LogManager.getLogger(CalendarController.class);

    private String cause;
    private String timeOfApp;
    private LocalDate dateOfApp;
    private Patient patient;
    @JsonIgnore
    public String appointmentValue;

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

        try {
            if (cause.trim().equals("") || cause.trim().matches("[a-zA-Z]*")){
                this.cause = cause;
                logger.info("correct cause entered");
            }
            else{throw new Exception("incorrect cause");}
        } catch (Exception e) {
            logger.error("incorrect cause entered");
        }
    }

    public String getTimeOfApp() {
        return timeOfApp;
    }

    public void setTimeOfApp(String timeOfApp) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time=LocalTime.parse(timeOfApp,formatter);
            LocalTime late = LocalTime.of(18, 0);
            LocalTime early = LocalTime.of(9, 0);

            if (time.isBefore(late)&&time.isAfter(early)){
                this.timeOfApp = timeOfApp;
                logger.info("correct time entered");
            }
            else{throw new Exception("incorrect time of appointment");}
        } catch (Exception e) {
            logger.error("incorrect time of appointment entered");
        }
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate getDateOfApp() {
        return dateOfApp;
    }

    @JsonSerialize(using = LocalDateSerializer.class)
    public void setDateOfApp(LocalDate dateOfApp) {

        try {
            System.out.println("date validator is working");

            LocalDate now= LocalDate.now();
            Long days = ChronoUnit.DAYS.between(dateOfApp, now);
            if (days <0){
                this.dateOfApp = dateOfApp;
            }
            else{throw new Exception("incorrect date of appointment");}
        } catch (Exception e) {
            logger.error("incorrect date of appointment entered");
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getAppointmentValue() {
        return this.patient.getName()+"/"+this.patient.getSurname()+" /"+getCause()+"\n"+getTimeOfApp();
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
