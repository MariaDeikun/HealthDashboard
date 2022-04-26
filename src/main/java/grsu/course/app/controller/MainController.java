package grsu.course.app.controller;


import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.EmptyAppointment;
import grsu.course.app.entity.Patient;
import grsu.course.app.service.impl.AppointmentService;
import grsu.course.app.service.impl.EmptyAppointmentService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.TreeMap;


public class MainController implements Initializable {
    @FXML
    public BarChart<String, Number> chart;
    public TextField name;
    public TextField surname;
    public TextField secondName;
    public TextField time;
    public DatePicker dob;
    public DatePicker dateOfApp;
    public TextField cause;

    @FXML
    MenuItem house = new MenuItem("Dr.House");
    @FXML
    MenuItem wilson = new MenuItem("Dr.Wilson");
    @FXML
    MenuButton doctor = new MenuButton("select doctor", null, house, wilson);

    @FXML
    MenuItem male = new MenuItem("male");
    @FXML
    MenuItem female = new MenuItem("female");
    @FXML
    MenuButton gender = new MenuButton("select doctor", null, male, female);


    private AppointmentService appointmentService;
    private EmptyAppointmentService emptyAppointmentService;

    public MainController() {
        appointmentService = new AppointmentService();
        emptyAppointmentService = new EmptyAppointmentService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        house.setOnAction(e -> {
            doctor.setText(house.getText());
        });
        wilson.setOnAction(e -> {
            doctor.setText(wilson.getText());
        });

        male.setOnAction(e -> {
            gender.setText(male.getText());
        });
        female.setOnAction(e -> {
            gender.setText(female.getText());
        });

    }

    TreeMap appointments=new TreeMap<String, EmptyAppointment>();
    @FXML
    public void clickHandler(MouseEvent mouseEvent) throws IOException {
        if(Objects.equals(name.getText(), "") && Objects.equals(surname.getText(), "") && Objects.equals(secondName.getText(), "")){
            EmptyAppointment emptyAppointment = new EmptyAppointment(dateOfApp.getValue(), time.getText(), cause.getText());
            this.emptyAppointmentService.addToMapOfAppointments(emptyAppointment, appointments);
            this.emptyAppointmentService.saveAppointments(appointments);
        }
        else {
            Patient patient = new Patient(name.getText(), surname.getText(), secondName.getText(), dob.getValue(), gender.getText(), false);
            Appointment appointment = new Appointment(dateOfApp.getValue(), time.getText(), cause.getText(), patient);
            this.appointmentService.addToMapOfAppointments(appointment, appointments);
            this.appointmentService.saveAppointments(appointments);
        }
    }
}