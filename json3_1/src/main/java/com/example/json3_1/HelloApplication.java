package com.example.json3_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Odczyt danych z linku");

        VBox root = new VBox(10);

        try {
            String url = "http://zasob.itmargen.com/4TD/";
            InputStream inputStream = new URL(url).openStream();
            Scanner scanner = new Scanner(inputStream);
            String jsonText = scanner.useDelimiter("\\A").next();
            scanner.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(jsonText);

            JSONObject infoObject = (JSONObject) jsonData.get("info");
            String infoText = "Przedmiot: " + infoObject.get("przedmiot") +
                    "\nProwadzący: " + infoObject.get("prowadzacy") +
                    "\nSzkola: " + infoObject.get("szkola") +
                    "\nMiasto: " + infoObject.get("miasto") +
                    "\nData i czas: " + infoObject.get("dataczas");
            Label infoLabel = new Label("Sekcja INFO:\n" + infoText);

            JSONObject group2Object = (JSONObject) jsonData.get("Grupa2");
            String yourName = (String) group2Object.get("1");
            Label nameLabel = new Label("Twoje imię i nazwisko z grupy2: " + yourName);

            root.getChildren().addAll(infoLabel, nameLabel);

        } catch (IOException e) {
            e.printStackTrace();
            Label errorLabel = new Label("Błąd podczas pobierania danych z linku.");
            root.getChildren().add(errorLabel);
        } catch (Exception e) {
            e.printStackTrace();
            Label errorLabel = new Label("Błąd podczas przetwarzania danych JSON.");
            root.getChildren().add(errorLabel);
        }

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
