package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creating an image
        Image image = new Image("https://www.tutorialspoint.com/green/images/logo.png");

//Setting the image view
        ImageView imageView = new ImageView(image);

//Setting the position of the image
        imageView.setX(100);
        imageView.setY(70);

//setting the fit height and width of the image view
        imageView.setFitHeight(200);
        imageView.setFitWidth(400);

//Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
    }
    public static void main(String args[]){
        launch(args);
    }
}