package me.zeaxerr.odbijajacekolko;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class OdbijajaceKolko extends Application {

    private static int SCENE_WIDTH = 800;
    private static int SCENE_HEIGHT = 600;
    private static final int BALL_RADIUS = 20;

    private double ballX = SCENE_WIDTH / 2;
    private double ballY = SCENE_HEIGHT / 2;
    private double ballSpeedX;
    private double ballSpeedY;

    private Circle ball;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        ball = new Circle(ballX, ballY, BALL_RADIUS, Color.RED);

        root.getChildren().add(ball);

        Random random = new Random();

        ballSpeedX = random.nextDouble() * 40 - 2;
        ballSpeedY = random.nextDouble() * 40 - 2;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                ball.setCenterX(ballX);
                ball.setCenterY(ballY);

                ballX += ballSpeedX;
                ballY += ballSpeedY;

                if (ballX - BALL_RADIUS <= 0 || ballX + BALL_RADIUS >= scene.getWidth()) {
                    ballSpeedX *= -1;
                }
                if (ballY - BALL_RADIUS <= 0 || ballY + BALL_RADIUS >= scene.getHeight()) {
                    ballSpeedY *= -1;
                }
            }
        };
        timer.start();

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            SCENE_WIDTH = newVal.intValue();
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            SCENE_HEIGHT = newVal.intValue();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Odbijajace Kolko");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
