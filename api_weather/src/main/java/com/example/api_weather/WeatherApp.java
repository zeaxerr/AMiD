package com.example.api_weather;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp extends Application {
    private static final String API_KEY = "09c4cf3bb8f370627714bb157f7a3b39";
    private TextArea weatherInfoTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("API Pogody");

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        HBox searchBox = new HBox();
        searchBox.setAlignment(Pos.CENTER);
        searchBox.setSpacing(10);

        TextField cityTextField = new TextField();
        cityTextField.setPromptText("Wpisz nazwę miasta");
        Button searchButton = new Button();
        Image searchImage = new Image(getClass().getResourceAsStream("/search2.png"));
        ImageView imageView = new ImageView(searchImage);
        searchButton.setGraphic(imageView);
        searchButton.setMaxWidth(50);
        searchButton.setMaxHeight(50);


        searchButton.setOnAction(e -> {
            try {
                String cityName = cityTextField.getText();
                if (!cityName.isEmpty()) {
                    String weatherData = getWeatherData(cityName);
                    if (weatherData != null) {
                        displayWeatherInfo(weatherData);
                    } else {
                        displayErrorMessage();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        searchBox.getChildren().addAll(cityTextField, searchButton);

        weatherInfoTextArea = new TextArea();
        weatherInfoTextArea.setEditable(false);

        borderPane.setTop(searchBox);
        borderPane.setCenter(weatherInfoTextArea);

        primaryStage.setScene(new Scene(borderPane, 400, 300));
        primaryStage.show();
    }

    private String getWeatherData(String cityName) {
        try {
            final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
            String apiUrl = String.format("%s?q=%s&appid=%s&lang=pl&units=metric", BASE_URL, cityName, API_KEY);
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            conn.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void displayWeatherInfo(String weatherData) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(weatherData);

            JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
            JSONObject weather = (JSONObject) weatherArray.get(0);
            String description = (String) weather.get("description");
            String icon = (String) weather.get("icon");
            Image weatherIconImage = new Image("http://openweathermap.org/img/wn/" + icon + "@2x.png");
            ImageView weatherIcon = new ImageView(weatherIconImage);
            weatherIcon.setFitHeight(50);
            weatherIcon.setFitWidth(50);

            JSONObject main = (JSONObject) jsonObject.get("main");
            double temp = (double) main.get("temp");
            double tempMin = (double) main.get("temp_min");
            double tempMax = (double) main.get("temp_max");
            double feels_like = (double) main.get("feels_like");
            long humidity = (long) main.get("humidity");
            long pressure = (long) main.get("pressure");
            //String temp = jsonObject.get("temp").toString();
            //String temp_min = jsonObject.get("temp_min").toString();
            //String humidity = jsonObject.get("humidity").toString();
            //String pressure = jsonObject.get("pressure").toString();
            //String feels_like = jsonObject.get("feels_like").toString();
            //String temp_max = jsonObject.get("temp_max").toString();

            String visibility = jsonObject.get("visibility").toString();

            JSONObject wind = (JSONObject) jsonObject.get("wind");
            String windSpeed = wind.get("speed").toString();
            String windDirection = wind.containsKey("deg") ? wind.get("deg").toString() : "Brak danych o kierunku";

            JSONObject rain = (JSONObject) jsonObject.get("rain");
            String rainInfo = rain != null ? rain.toJSONString() : "Brak danych o deszczu";

            JSONObject snow = (JSONObject) jsonObject.get("snow");
            String snowInfo = snow != null ? snow.toJSONString() : "Brak danych o śniegu";

            JSONObject clouds = (JSONObject) jsonObject.get("clouds");
            String cloudsInfo = clouds.get("all").toString();

            String cityName = jsonObject.get("name").toString();

            weatherInfoTextArea.setText("Opis pogody: " + description + "\n"
                    + "Ikona pogody: " + weatherIcon + "\n"
                    + "Temperatura: " + temp + "\n"
                    + "Temperatura minimalna: " + tempMin + "\n"
                    + "Humidity: " + humidity + "\n"
                    + "Ciśnienie: " + pressure + "\n"
                    + "Odczuwalna: " + feels_like + "\n"
                    + "Temperatura maksymalna: " + tempMax + "\n"
                    + "Widoczność: " + visibility + "\n"
                    + "Prędkość wiatru: " + windSpeed + "\n"
                    + "Kierunek wiatru: " + windDirection + "\n"
                    + "Deszcz: " + rainInfo + "\n"
                    + "Śnieg: " + snowInfo + "\n"
                    + "Zachmurzenie: " + cloudsInfo + "\n"
                    + "Nazwa miasta: " + cityName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayErrorMessage() {
        weatherInfoTextArea.setText("Błąd pobierania danych pogodowych. Spróbuj ponownie.");
    }
}
