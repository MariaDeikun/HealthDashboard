package grsu.course.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Patient {
    private String name;
    private String surname;
    private String secondName;
    private LocalDate DOB;
    private String gender;
    private Boolean cured;

    public Patient() {}

    public Patient(String name, String surname, String secondName, LocalDate DOB, String gender, Boolean cured) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.DOB = DOB;
        this.gender = gender;
        this.cured = cured;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public Boolean getCured() {
        return this.cured;
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
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setCured(Boolean cured) {
        this.cured = cured;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}

