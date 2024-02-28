package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class ComplexShape extends Application {
    @Override
    public void start(Stage stage) {
        //Creating a Path
        Path path = new Path();

        //Moving to the starting point
        MoveTo moveTo = new MoveTo(165, 35);

        //Creating 1st line
        LineTo line1 = new LineTo(329, 130);

        //Creating 2nd line
        LineTo line2 = new LineTo(165,240);

        //Creating 3rd line
        LineTo line3 = new LineTo(240,10);

        //Creating 4th line
        LineTo line4 = new LineTo(290, 270);

        //Creating 4th line
        LineTo line5 = new LineTo(165, 35);

        //Adding all the elements to the path
        path.getElements().add(moveTo);
        path.getElements().addAll(line1, line2, line3, line4, line5);

        //Creating a Group object
        Group root = new Group(path);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Drawing an arc through a path");

        stage.setScene(scene);

        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
