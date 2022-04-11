module grsu.course.app1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens grsu.course.app to javafx.fxml;
    exports grsu.course.app;
    exports grsu.course.app.controller;
    opens grsu.course.app.controller to javafx.fxml;
    exports grsu.course.app.entity;
    opens grsu.course.app.entity to javafx.fxml;
}