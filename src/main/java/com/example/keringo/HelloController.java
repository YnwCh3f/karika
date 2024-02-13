package com.example.keringo;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML private Slider sSpeed;
    @FXML private Slider sRadius;
    @FXML private Label lbSpeed;
    @FXML private Label lbRadius;
    @FXML private Pane pn;

   /*@FXML private void onSlider(){
        lbSpeed.setText(String.format("Speed: %.0f",sSpeed.getValue()));

    }*/

    public void initialize(){
        lbSpeed.textProperty().bind(Bindings.format("Speed: %.0f", sSpeed.valueProperty()));
        lbRadius.textProperty().bind(Bindings.format("Radius: %.0f", sRadius.valueProperty()));
        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
    }
}