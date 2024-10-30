module com.example.samochod {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.samochod to javafx.fxml;
    exports com.example.samochod;
}