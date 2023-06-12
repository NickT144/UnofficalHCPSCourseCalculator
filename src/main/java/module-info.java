module com.example.finalgradecalculate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.finalgradecalculate to javafx.fxml;
    exports com.example.finalgradecalculate;
}