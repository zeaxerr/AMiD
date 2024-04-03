module me.zeaxerr.odbijajacekolko {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.zeaxerr.odbijajacekolko to javafx.fxml;
    exports me.zeaxerr.odbijajacekolko;
}