package com.gerus.epam.lab4.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.gerus.epam.lab4.model.FeedingTrough;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label FeedingTrough;

    @FXML
    private Button EatButton;

    @FXML
    void initialize() {

        FeedingTrough feed = new FeedingTrough();
        EatButton.setOnAction(actionEvent -> {
            try {
                feed.createAnimal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }
}