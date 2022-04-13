package grsu.course.app.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.Entity;
import grsu.course.app.service.IAppointmentService;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class AppointmentService implements IAppointmentService {

    TreeMap appointments=new TreeMap<String, Appointment>();

    @Override
    public void addToMapOfAppointments(Appointment appointment) {

        appointments.put(Entity.createId(),appointment);
        System.out.println(appointments);
    }

    public void saveAppointments() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("D:\\Java\\app1\\appointments.json");
        mapper.writeValue(file, appointments);
    }
//    public void serializeMapOfString() throws JsonProcessingException {
//        var mapper = new ObjectMapper();
//        var personNames = new TreeMap<String, String>();
//        personNames.put("name1", "Juan Garcia");
//        personNames.put("name2", "Manuel Perez");
//        var json = mapper.writeValueAsString(personNames);
//        log.info("A simple map of <String, String>: {}", json);
//        assertThat(json).isEqualTo(
//                "{\"name1\":\"Juan Garcia\",\"name2\":\"Manuel Perez\"}"
//        );
//    }

}
