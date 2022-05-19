package grsu.course.app.controller;


import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.EmptyAppointment;
import grsu.course.app.entity.Patient;
import grsu.course.app.service.impl.AppointmentService;
import grsu.course.app.service.impl.EmptyAppointmentService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class MainController implements Initializable {
    private static final Logger logger = LogManager.getLogger(MainController.class);
    @FXML

    public TextField name;
    public TextField surname;
    public TextField secondName;
    public TextField time;
    public DatePicker dob;
    public DatePicker dateOfApp;
    public TextField cause;
    public TextField localDate;

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

    TreeMap appointments = new TreeMap<String, EmptyAppointment>();


    private AppointmentService appointmentService;
    private EmptyAppointmentService emptyAppointmentService;
    LocalDate now= LocalDate.now();

    public MainController() throws ParseException {
        appointmentService = new AppointmentService();
        emptyAppointmentService = new EmptyAppointmentService();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("Main page initialization");

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

        localDate.setText(LocalDate.now().toString());


    }


    @FXML
    public void clickHandler(MouseEvent mouseEvent) throws IOException {
        logger.info("Add appointment handler");
        if(Objects.equals(name.getText(), "") && Objects.equals(surname.getText(), "") && Objects.equals(secondName.getText(), "")){
            Appointment emptyAppointment = new EmptyAppointment(dateOfApp.getValue(), time.getText(), cause.getText());
            logger.info("Create an empty appointment: {}", emptyAppointment);
            this.emptyAppointmentService.addToMapOfAppointments(emptyAppointment, appointments);
            this.emptyAppointmentService.saveAppointments(appointments);
        }
        else {
            Patient patient = new Patient(name.getText(), surname.getText(), secondName.getText(), dob.getValue(), gender.getText());
            Appointment appointment = new Appointment(dateOfApp.getValue(), time.getText(), cause.getText(), patient);
            logger.info("Create an appointment: {}", appointment);
            this.appointmentService.addToMapOfAppointments(appointment, appointments);
            this.appointmentService.saveAppointments(appointments);
        }
    }
}