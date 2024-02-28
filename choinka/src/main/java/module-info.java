module com.example.choinka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.choinka to javafx.fxml;
    exports com.example.choinka;
}