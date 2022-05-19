package grsu.course.app.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CalendarService {


    public Map getAllAppointments() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        File file = new File("D:\\Java\\app1\\appointments.json");
        TypeReference<TreeMap<String, Appointment>> typeRef = new TypeReference<>() {};
        Map map = mapper.readValue(file, typeRef);
        return map;
    }

    public ObservableList<Appointment> getListOfObjects(Map<String, Appointment> map, LocalDate date){
        Set<Map.Entry<String, Appointment>> entries = map.entrySet();

        ObservableList<Appointment> appsForWeek = FXCollections.observableArrayList();
        for (Map.Entry<String, Appointment> entry : entries) {

            LocalDate appDate = entry.getValue().getDateOfApp();
            if(appDate.equals(date)){
                appsForWeek.add( entry.getValue());
            }
        }
        return appsForWeek;
    }
}
