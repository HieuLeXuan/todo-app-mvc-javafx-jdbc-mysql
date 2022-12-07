package com.hieulexuan.todoapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class TodoView extends Application {
    TextField nameTF;
    TextField descriptionTF;
    DatePicker datePicker;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Todo Application");
        stage.setWidth(400);
        stage.setHeight(220);
        stage.setX(1000);
        stage.setY(200);
        stage.setResizable(false);

        Label addNewTitle = new Label("ADD NEW TO DO");
        Label nameLabel = new Label("Name:");
        nameTF = new TextField();
        nameTF.setPromptText("Enter name");
        nameTF.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if (!nameTF.getText().matches("^[a-zA-Z0-9 ]*$")) {
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    nameTF.setText("");
                }
            }
        });

        Label descriptionLabel = new Label("Description:");
        descriptionTF = new TextField();
        descriptionTF.setPromptText("Enter description");
        descriptionTF.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if (!descriptionTF.getText().matches("^[a-zA-Z0-9 ]*$")) {
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    descriptionTF.setText("");
                }
            }
        });

        Label dateLabel = new Label("Date:");
        datePicker = new DatePicker(LocalDate.now());

        Button saveBtn = new Button("Save");

        GridPane gridPane = new GridPane();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTF, 1, 0);
        gridPane.add(descriptionLabel, 0, 1);
        gridPane.add(descriptionTF, 1, 1);
        gridPane.add(dateLabel, 0, 2);
        gridPane.add(datePicker, 1, 2);
        gridPane.add(saveBtn, 0, 3);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // handle save button click
        saveBtn.setOnAction(event -> {
            Todo todo = new Todo();
            todo.setName(nameTF.getText());
            todo.setDescription(descriptionTF.getText());
            todo.setDate(Timestamp.valueOf(datePicker.getValue().atStartOfDay()));

            ManagerTodo managerTodo = new ManagerTodo();
            try {
                managerTodo.insertTodo(todo);
                resetForm();
                System.out.println("Insert data success!");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Insert data failed!");
            }
        });

        HBox hBoxTitle = new HBox(addNewTitle);
        hBoxTitle.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(gridPane);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(hBoxTitle, hBox);

        Scene scene = new Scene(vBox, 400, 600);

//        HBox hBoxNewTitle = new HBox();
//        Label addNewTitle = new Label("ADD NEW TO DO");
//        hBoxNewTitle.getChildren().add(addNewTitle);

        stage.setScene(scene);
        stage.show();
    }

    private void resetForm() {
        nameTF.setText("");
        descriptionTF.setText("");
        datePicker.setValue(LocalDate.now());
    }

    public static void main(String[] args) {
        launch();
    }
}