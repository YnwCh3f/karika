package com.example.keringo;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML private Slider sSpeed;
    @FXML private Slider sRadius;
    @FXML private Label lbSpeed;
    @FXML private Label lbRadius;
    @FXML private Pane pn;
    @FXML private Button btStart;

    private AnimationTimer at;
    private int alfa = 0;
    private Circle kor = new Circle(300,300,200, Color.LIGHTGREEN);
    private ImageView ivBall = new ImageView(new Image(getClass().getResourceAsStream("ball1.png")));

   @FXML private void onStartClick(){
       if (btStart.getText().equals("Start")){
           at.start();
           btStart.setText("Stop");
       }else{
           at.stop();
           btStart.setText("Start");
       }

    }

    public void initialize(){
        pn.setClip(new Rectangle(600, 600));
        lbSpeed.textProperty().bind(Bindings.format("Speed: %.0f", sSpeed.valueProperty()));
        lbRadius.textProperty().bind(Bindings.format("Radius: %.0f", sRadius.valueProperty()));
        ivBall.setLayoutX(500-32);
        ivBall.setLayoutY(300-32);
        pn.getChildren().add(kor);
        pn.getChildren().add(ivBall);
        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                mozgat();
            }
        };
    }

    private void mozgat(){
        int r = (int)(sRadius.getValue());
        int x = 300 + (int)(r * Math.cos(alfa*Math.PI/180));
        int y = 300 - (int)(r * Math.sin(alfa*Math.PI/180));
        kor.setRadius(r);
        ivBall.setLayoutY(y-32);
        ivBall.setLayoutX(x-32);
        int speed = (int)(sSpeed.getValue());
        alfa += speed;
    }

    private void setKep(int i){
       ivBall.setImage(new Image(getClass().getResourceAsStream("ball"+i+".png")));
    }

    @FXML private void onUClick(){
       setKep(1);
    }
    @FXML private void onDClick(){
        setKep(2);
    }
}
