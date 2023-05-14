module com.example.seguimiento14 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.seguimiento14 to javafx.fxml;
    exports com.example.seguimiento14;

    opens com.example.seguimiento14.Model to javafx.fxml;
    exports com.example.seguimiento14.Model;
}