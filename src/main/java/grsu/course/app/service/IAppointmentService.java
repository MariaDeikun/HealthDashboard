package grsu.course.app.service;

import grsu.course.app.entity.Appointment;

import java.io.IOException;

public interface IAppointmentService {
    public void addToMapOfAppointments(Appointment appointment);
    public void saveAppointments() throws IOException;
}
