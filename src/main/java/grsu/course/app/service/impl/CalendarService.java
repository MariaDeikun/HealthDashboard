package grsu.course.app.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class CalendarService {


    public Map getAllAppointments() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        File file = new File("D:\\Java\\app1\\appointments.json");
        TypeReference<TreeMap<String, Appointment>> typeRef = new TypeReference<>() {};
        Map map = mapper.readValue(file, typeRef);
        return map;
    }
    public int getWeekNumber(DatePicker datePick){
        LocalDate date = datePick.getValue();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumber = date.get(woy);
        return weekNumber;

    }
    public ObservableList<Appointment> getListOfObjects(Map<String, Appointment> map, int weekNumber){
        Set<Map.Entry<String, Appointment>> entries = map.entrySet();

        ObservableList<Appointment> appsForWeek = FXCollections.observableArrayList();
        for (Map.Entry<String, Appointment> entry : entries) {

            TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
            int appWeekNumber = entry.getValue().getDateOfApp().get(woy);
            if(appWeekNumber == weekNumber){
                appsForWeek.add( entry.getValue());
            }
        }
        return appsForWeek;
    }
}
