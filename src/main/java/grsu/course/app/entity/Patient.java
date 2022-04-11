package grsu.course.app.entity;

import java.time.LocalDate;

public class Patient extends Entity {
    private String name;
    private String surname;
    private String secondName;
    private LocalDate DOB;
    private String gender;
    private Boolean cured;

    public Patient(Integer id, String name, String surname, String secondName, LocalDate DOB, String gender, Boolean cured) {
        super(id);
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

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}

