package com.example.dataczas;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HelloApplication extends Application {

    private Label countdownLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Odliczanie do 2025 roku");

        countdownLabel = new Label();
        StackPane root = new StackPane();
        root.getChildren().add(countdownLabel);
        primaryStage.setScene(new Scene(root, 400, 400));

        primaryStage.show();

        startCountdown();
    }

    private void startCountdown() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateCountdown())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void updateCountdown() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newYear = LocalDateTime.of(now.getYear() + 1, 1, 1, 0, 0, 0);

        long seconds = ChronoUnit.SECONDS.between(now, newYear);

        long days = seconds / (24 * 3600);
        long hours = (seconds % (24 * 3600)) / 3600;
        long minutes = ((seconds % (24 * 3600)) % 3600) / 60;
        long secs = ((seconds % (24 * 3600)) % 3600) % 60;

        String countdownText = String.format("Pozostało %02d dni, %02d godzin, %02d minut i %02d sekund do 2025.", days, hours, minutes, secs);
        countdownLabel.setText(countdownText);
    }

}
