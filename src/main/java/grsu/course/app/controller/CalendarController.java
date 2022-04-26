package grsu.course.app.controller;

import grsu.course.app.entity.Appointment;
import grsu.course.app.service.impl.CalendarService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class CalendarController implements Initializable {


    @FXML
    public TableView<String> table;
    public CalendarService calendarService=new CalendarService();
    public DatePicker datePick;
    public TableColumn mon;
    public TableColumn tue;
    public TableColumn wed;
    public TableColumn thu;
    public TableColumn fri;


    public Map map;
    public Integer weekNumber;
    public Map<String, Appointment> appsForWeek;

    public void getData(ActionEvent actionEvent) throws IOException{
        map = this.calendarService.getAllAppointments();
        weekNumber=this.calendarService.getWeekNumber(datePick);
        appsForWeek=this.calendarService.getListOfObjects(map, weekNumber);
        System.out.println(appsForWeek);


        Set<Map.Entry<String, Appointment> > entries = map.entrySet();
        for (Map.Entry<String, Appointment> entry : entries) {
            String text = entry.getValue().getPatient().getName()+" "+ entry.getValue().getPatient().getSurname()+"\n"+ entry.getValue().getCause()+" "+ entry.getValue().getTimeOfApp();
            switch (entry.getKey()) {
                case "MONDAY":
                    mon.setText(text);
                    break;
                case "TUESDAY":
                    tue.setText(text);
                    break;
                case "WEDNESDAY":
                    wed.setText(text);
                    break;
                case "THURSDAY":
                    thu.setText(text);
                    break;
                case "FRIDAY":
                    fri.setText(text);
                    break;
                default:
                    break;
            }
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
