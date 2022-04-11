package grsu.course.app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import grsu.course.app.service.IAppointmentService;

import java.io.File;
import java.io.IOException;

public class AppointmentService implements IAppointmentService {
    @Override
    public void createAppointment() {

    }

    public void saveAppointment(Appointment appointment) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("D:\\Java\\app1\\appointments.json");
        mapper.writeValue(file, appointment);
    }
}
