module grsu.course.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires jackson.annotations;
    requires com.fasterxml.jackson.core;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;


    opens grsu.course.app to javafx.fxml;
    exports grsu.course.app;
    exports grsu.course.app.controller;
    opens grsu.course.app.controller to javafx.fxml;
    exports grsu.course.app.entity;
    opens grsu.course.app.entity to javafx.fxml;
}