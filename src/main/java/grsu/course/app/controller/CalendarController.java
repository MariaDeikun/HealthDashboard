package grsu.course.app.controller;

import grsu.course.app.entity.Appointment;
import grsu.course.app.service.impl.CalendarService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;

public class CalendarController implements Initializable {
    private static final Logger logger = LogManager.getLogger(CalendarController.class);

    @FXML
    public TableView<Appointment> table;
    public CalendarService calendarService=new CalendarService();
    public DatePicker datePick;
    public TableColumn name;
    public TableColumn surname;
    public TableColumn cause;
    public TableColumn time;



    public Map<String,Appointment> map;
    public ObservableList<Appointment> appsForDay;

    public void getData(ActionEvent actionEvent) throws IOException {
        map = this.calendarService.getAllAppointments();
        LocalDate date = datePick.getValue();
        logger.info("Get data by week {}", map);

        appsForDay = this.calendarService.getListOfObjects(map, date);
        System.out.println(appsForDay);

        for (Appointment appointment : appsForDay) {

            name.setCellValueFactory(new PropertyValueFactory<Appointment, String>("patientName"));
            surname.setCellValueFactory(new PropertyValueFactory<Appointment, String>("patientSurname"));
            cause.setCellValueFactory(new PropertyValueFactory<Appointment, String>("cause"));
            time.setCellValueFactory(new PropertyValueFactory<Appointment, String>("timeOfApp"));
        }
        table.setItems(appsForDay);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
