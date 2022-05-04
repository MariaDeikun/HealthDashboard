package grsu.course.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import grsu.course.app.controller.CalendarController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.HOUR;
import static org.apache.logging.log4j.core.util.datetime.FixedDateFormat.FixedTimeZoneFormat.HH;

public class EmptyAppointment {
    private static final Logger logger = LogManager.getLogger(CalendarController.class);

    private String cause;
    private String timeOfApp;
    private LocalDate dateOfApp;

    public EmptyAppointment () {}

    public EmptyAppointment(LocalDate dateOfApp, String timeOfApp, String cause) {

        setDateOfApp(dateOfApp);
        setTimeOfApp(timeOfApp);
        setCause(cause);

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
    public String getAppointmentValue() {
        return getCause()+"\n"+getTimeOfApp();
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
