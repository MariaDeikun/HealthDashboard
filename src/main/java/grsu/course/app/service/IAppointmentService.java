package grsu.course.app.service;

import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.EmptyAppointment;

import java.io.IOException;
import java.util.TreeMap;

public interface IAppointmentService {
     void addToMapOfAppointments(EmptyAppointment appointment, TreeMap appointments);

     void saveAppointments(TreeMap appointments) throws IOException;
}
