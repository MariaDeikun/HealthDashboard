package grsu.course.app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.AppointmentForDr;
import grsu.course.app.entity.Entity;
import grsu.course.app.service.IAppointmentService;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class AppointmentForDrService implements IAppointmentService {

    TreeMap appointments=new TreeMap<String, Appointment>();

    @Override
    public void addToMapOfAppointments(Appointment appointment) {
        appointments.put(Entity.createId(),appointment);
        System.out.println(appointments);
    }

    @Override
    public void saveAppointments() throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("D:\\Java\\app1\\appointments.json");
            mapper.writeValue(file, appointments);

    }
}
