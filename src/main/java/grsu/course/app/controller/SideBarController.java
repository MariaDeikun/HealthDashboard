package grsu.course.app.controller;

import grsu.course.app.LaunchApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;


public class SideBarController extends Application {
    @FXML
    private BorderPane mainPane;

    public static void main(String[] args) {
        launch(args);
    }

   public void switchToMain(ActionEvent event) throws IOException {
        Parent root= load(LaunchApp.class.getResource("Main.fxml"));
        mainPane.setCenter(root);
    }

    public void switchToCalendar(ActionEvent event) throws IOException {
        Parent root= load(LaunchApp.class.getResource("Calendar.fxml"));
        mainPane.setCenter(root);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}