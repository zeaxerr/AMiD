module com.example.dataczas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dataczas to javafx.fxml;
    exports com.example.dataczas;
}