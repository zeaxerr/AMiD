module com.zeaxerr.animacja_zadanie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zeaxerr.animacja_zadanie to javafx.fxml;
    exports com.zeaxerr.animacja_zadanie;
}