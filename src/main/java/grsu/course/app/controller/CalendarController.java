package grsu.course.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.EmptyAppointment;
import grsu.course.app.service.impl.CalendarService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Set;
import java.util.TreeMap;

public class CalendarController implements Initializable {


    @FXML
    public TableView<String> table;
    public CalendarService calendarService=new CalendarService();
    public DatePicker datePick;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getData(ActionEvent actionEvent) throws IOException{
        Map map = this.calendarService.getAllAppointments();
        Integer weekNumber=this.calendarService.getWeekNumber(datePick);
        Map<String, Appointment>appsForWeek=this.calendarService.getListOfObjects(map, weekNumber);
        System.out.println(appsForWeek);

    }
}
