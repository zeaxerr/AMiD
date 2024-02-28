module com.example.api_weather {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.api_weather to javafx.fxml;
    exports com.example.api_weather;
}