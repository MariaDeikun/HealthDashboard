package grsu.course.app.controller;

import grsu.course.app.entity.Appointment;
import grsu.course.app.service.impl.CalendarService;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CalendarController implements Initializable {
    private static final Logger logger = LogManager.getLogger(CalendarController.class);

    @FXML
    public TableView<Appointment> table;
    public CalendarService calendarService=new CalendarService();
    public DatePicker datePick;
    public TableColumn mon;
    public TableColumn tue;
    public TableColumn wed;
    public TableColumn thu;
    public TableColumn fri;


    public Map<String,Appointment> map;
    public Integer weekNumber;
    public ObservableList<Appointment> appsForWeek;

    public void getData(ActionEvent actionEvent) throws IOException{
        map = this.calendarService.getAllAppointments();

        weekNumber = this.calendarService.getWeekNumber(datePick);

        logger.info("Get data by week {}", map);

        appsForWeek = this.calendarService.getListOfObjects(map, weekNumber);
        System.out.println(appsForWeek);

       for( Appointment appointment : appsForWeek) {
            DayOfWeek dow = appointment.getDateOfApp().getDayOfWeek();
            switch (dow) {
                case MONDAY -> mon.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentValue"));
                case TUESDAY -> tue.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentValue"));
                case WEDNESDAY -> wed.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentValue"));
                case THURSDAY -> thu.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentValue"));
                case FRIDAY -> fri.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentValue"));
                default -> {
                }
            }
        }
        table.setItems(appsForWeek);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
