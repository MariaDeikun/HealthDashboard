package grsu.course.app.controller;


import grsu.course.app.entity.Appointment;
import grsu.course.app.entity.Patient;
import grsu.course.app.service.impl.AppointmentService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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

    public MainController() {
        appointmentService = new AppointmentService();
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

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("mon", 3));
        series.getData().add(new XYChart.Data<>("tue", 5));
        series.getData().add(new XYChart.Data<>("wed", 10));
        series.getData().add(new XYChart.Data<>("thu", 3));
        series.getData().add(new XYChart.Data<>("fri", 7));
        series.getData().add(new XYChart.Data<>("sat", 2));
        chart.getData().add(series);
    }


    @FXML
    public void clickHandler(MouseEvent mouseEvent) throws IOException {
        Patient patient = new Patient(12, name.getText(), surname.getText(), secondName.getText(), dob.getValue(), gender.getText(), false);
        Appointment appointment = new Appointment(13, dateOfApp.getValue(), time.getText(), cause.getText(), doctor.getText(), patient);
        this.appointmentService.saveAppointment(appointment);
        System.out.println(appointment);
    }
}