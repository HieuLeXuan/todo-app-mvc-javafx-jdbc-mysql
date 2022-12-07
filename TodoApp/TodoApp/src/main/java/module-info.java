module com.hieulexuan.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.java;

    opens com.hieulexuan.todoapp to javafx.fxml;
    exports com.hieulexuan.todoapp;
}