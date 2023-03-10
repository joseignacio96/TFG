module com.example.prueba2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.commons;
    requires de.jensd.fx.glyphs.iconsfivetwofive;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.media;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.prueba2 to javafx.fxml;
    opens com.example.prueba2.Modelo to javafx.base;
    exports com.example.prueba2;
}