module com.example.currencyexchange {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.currencyexchange to javafx.fxml;
    exports com.example.currencyexchange;
}