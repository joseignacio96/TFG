package com.example.prueba2;

import com.example.prueba2.Modelo.Cancion;
import com.example.prueba2.Modelo.CancionesSQL;
import de.jensd.fx.glyphs.icons525.Icons525;
import de.jensd.fx.glyphs.icons525.Icons525View;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Musica {

    @FXML
    private TableColumn<Cancion, String> columnAlbum;

    @FXML
    private TableColumn<Cancion, Double> columnDuration;

    @FXML
    private TableColumn<Cancion, String> columnTItle;

    @FXML
    private  TableView<Cancion> tabla;


    public void  initialize() {
        columnTItle.setCellValueFactory(new PropertyValueFactory<Cancion,String>("nombreCancion"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<Cancion,Double>("duracion"));
        tabla.setItems(Main.listCanciones);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public  String GetPathSong() {
        return tabla.getSelectionModel().getSelectedItem().getRuta();
    }

    public String GetNameFile() {
        return tabla.getSelectionModel().getSelectedItem().getNombreFichero();
    }
}
