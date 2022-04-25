package grsu.course.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.TreeMap;

public class CalendarController implements Initializable {


    @FXML
    public TableView<String> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getData(ActionEvent actionEvent) throws IOException, URISyntaxException {
//        CalendarService.getAppointments();
        ObjectMapper mapper=new ObjectMapper();
        File file = new File("D:\\Java\\app1\\appointments.json");
        TypeReference<TreeMap<String, Appointment>> typeRef
                = new TypeReference<TreeMap<String, Appointment>>() {};
        Map map = mapper.readValue(file, typeRef);
        System.out.println(map);
    }
}
