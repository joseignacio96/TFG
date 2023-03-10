module com.example.prueba2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.commons;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.media;

    opens com.example.prueba2 to javafx.fxml;
    exports com.example.prueba2;
}