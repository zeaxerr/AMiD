package com.example.demo1;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Image image = new Image("http://2.bp.blogspot.com/-WL1As4kdOP0/U9ACPO8izsI/AAAAAAAAHkM/4IKR1KPs3Lk/s1600/kot+tap.jpg");
        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(1600);
        imageView.setFitWidth(1200);

        imageView.setPreserveRatio(true);

        Bloom bloom = new Bloom();
        bloom.setThreshold(.5);
        imageView.setEffect(bloom);

        Rectangle kwadrat = new Rectangle(800, 800, Color.BLACK);
        kwadrat.setOpacity(.5);

        Rectangle prostokat = new Rectangle(800, 200, Color.WHITE);
        prostokat.setX(0);
        prostokat.setY(300);
        prostokat.setOpacity(1);

        Text text = new Text(350, 375, "TEST!");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        text.setFill(Color.ORANGE);

        DropShadow dp = new DropShadow();
        dp.setRadius(10);
        dp.setSpread(0.7);
        text.setEffect(dp);

        TranslateTransition tT = new TranslateTransition();
        tT.setDuration(Duration.seconds(1));
        tT.setNode(text);
        tT.setByX(100);
        tT.setByY(50);
        tT.setCycleCount(10);
        tT.setAutoReverse(true);
        tT.play();


        TranslateTransition tT1 = new TranslateTransition();
        tT1.setDuration(Duration.seconds(1));
        tT1.setNode(prostokat);
        tT1.setByY(-15);
        tT1.setAutoReverse(false);
        tT1.play();

        stage.setTitle("Test efektow");

        Group root = new Group();
        root.getChildren().addAll(imageView, kwadrat, prostokat,text);

        Scene scene = new Scene(root, 800, 800);


        stage.setScene(scene);

        stage.show();
    }

    private void wait(Duration seconds) {
    }

    public static void main(String args[]){
        launch(args);
    }
} 