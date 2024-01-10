module com.example.json3_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.json3_1 to javafx.fxml;
    exports com.example.json3_1;
}