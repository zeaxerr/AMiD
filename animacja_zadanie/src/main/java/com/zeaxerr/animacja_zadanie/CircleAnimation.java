package com.zeaxerr.animacja_zadanie;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleAnimation extends Application {
    private Timeline timeline;
    private Circle circle;
    private Color customColor = null;
    private int currentColorIndex = 0;
    private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW};

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Animation");

        circle = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, 50, Color.RED);
        root.getChildren().add(circle);

        Text message = new Text("Zresetowałeś animację!");
        message.setOpacity(0);
        double textWidth = message.getBoundsInLocal().getWidth();
        message.setX((scene.getWidth() - textWidth) / 2);
        message.setY(scene.getHeight() / 2 - 70);
        root.getChildren().add(message);

        HBox buttonBox = new HBox();
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button stepButton = new Button("Step");
        Button resetButton = new Button("Reset");
        Button applyColorButton = new Button("Apply Color");

        TextField redField = new TextField();
        redField.setPromptText("Red (0-255)");
        TextField greenField = new TextField();
        greenField.setPromptText("Green (0-255)");
        TextField blueField = new TextField();
        blueField.setPromptText("Blue (0-255)");

        buttonBox.getChildren().addAll(startButton, stopButton, stepButton, resetButton, redField, greenField, blueField, applyColorButton);
        root.setBottom(buttonBox);

        startButton.setOnAction(event -> startAnimation());
        stopButton.setOnAction(event -> stopAnimation());
        stepButton.setOnAction(event -> stepAnimation());
        resetButton.setOnAction(event -> resetAnimation(message, redField, greenField, blueField));
        applyColorButton.setOnAction(event -> applyColor(redField, greenField, blueField));

        primaryStage.show();
    }

    private void startAnimation() {
        if (timeline != null) {
            timeline.stop();
        }

        double maxRadius = Math.sqrt(Math.pow(circle.getParent().getLayoutBounds().getWidth(), 2) +
                Math.pow(circle.getParent().getLayoutBounds().getHeight(), 2)) / 2;

        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    if (customColor != null) {
                        circle.setFill(customColor);
                    } else {
                        circle.setFill(colors[currentColorIndex]);
                    }
                    circle.setRadius(1);
                }),
                new KeyFrame(Duration.seconds(2), e -> {
                    Timeline scaleTimeline = new Timeline(
                            new KeyFrame(Duration.ZERO, new javafx.animation.KeyValue(circle.radiusProperty(), 0)),
                            new KeyFrame(Duration.seconds(2), new javafx.animation.KeyValue(circle.radiusProperty(), maxRadius))
                    );
                    scaleTimeline.play();
                }),
                new KeyFrame(Duration.seconds(3), e -> {
                    if (customColor == null) {
                        currentColorIndex = (currentColorIndex + 10) % colors.length;
                    }
                })
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void stopAnimation() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    private void stepAnimation() {
        double maxRadius = Math.sqrt(Math.pow(circle.getParent().getLayoutBounds().getWidth(), 2) +
                Math.pow(circle.getParent().getLayoutBounds().getHeight(), 2)) / 2;

        double currentRadius = circle.getRadius();
        double newRadius = currentRadius + 10;

        circle.setRadius(newRadius);
        if (customColor != null) {
            circle.setFill(customColor);
        } else {
            circle.setFill(colors[currentColorIndex]);
        }
    }

    private void resetAnimation(Text message, TextField redField, TextField greenField, TextField blueField) {
        circle.setRadius(10);
        redField.clear();
        greenField.clear();
        blueField.clear();
        message.setOpacity(1);
        message.setText("Zresetowałeś animację!");

        Timeline fadeOut = new Timeline(
                new KeyFrame(Duration.seconds(3), new javafx.animation.KeyValue(message.opacityProperty(), 0))
        );
        fadeOut.play();
    }

    private void applyColor(TextField redField, TextField greenField, TextField blueField) {
        try {
            int red = Integer.parseInt(redField.getText());
            int green = Integer.parseInt(greenField.getText());
            int blue = Integer.parseInt(blueField.getText());

            if (red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255) {
                customColor = Color.rgb(red, green, blue);
            } else {
                System.out.println("Podane wartości koloru muszą być w zakresie od 0 do 255.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Podane wartości koloru są nieprawidłowe.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
