package grsu.course.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import grsu.course.app.controller.CalendarController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Patient {
    private static final Logger logger = LogManager.getLogger(CalendarController.class);

    private String name;
    private String surname;
    private String secondName;
    private LocalDate DOB;
    private String gender;


    public Patient() {}

    public Patient(String name, String surname, String secondName, LocalDate DOB, String gender) {
        setName(name);
        setSurname(surname);
        setSecondName(secondName);
        setDOB(DOB);
        setGender(gender);
    }

    public String getName() { return this.name; }

    public String getSurname() {
        return this.surname;
    }

    public String getSecondName() {
        return this.secondName;
    }

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    public LocalDate getDOB() {
        return this.DOB;
    }

    public String getGender() {
        return this.gender;
    }

    public void setName(String name) {
        try {
            if (name.trim().equals("") || name.trim().matches("[a-zA-Z]*")){
                this.name = name;
            }
            else{throw new Exception("incorrect name");}
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("incorrect name entered");
        }
    }

    public void setSurname(String surname) {
        try {
            if (surname.trim().equals("") || surname.trim().matches("[a-zA-Z]*")){
                this.surname = surname;
            }
            else{throw new Exception("incorrect surname");}
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("incorrect surname entered");
        }
    }

    public void setSecondName(String secondName) {
        try {
            if (secondName.trim().equals("") || secondName.trim().matches("[a-zA-Z]*")){
                this.secondName = secondName;
            }
            else{throw new Exception("incorrect second Name");}
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("incorrect second Name entered");
        }

    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public void setDOB(LocalDate DOB) {
        try {
            LocalDate now= LocalDate.now();
            long age = ChronoUnit.YEARS.between(DOB, now);

            if (!(age ==0)){
                this.DOB = DOB;
            }
            else{
                throw new Exception("incorrect date of birth");

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("incorrect date of birth entered");
        }
    }


}

