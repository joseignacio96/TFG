package com.example.prueba2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;


public class MainController {
    public Button btnPlay;
    public Button btnPause;
    public ImageView coverDies;


    private String userDir = System.getProperty("user.dir")+"\\src\\main\\resources\\musica\\helden.mp3";
    public HBox topBar;
    public TextField txtFieldLista;
    public ListView listaCanciones;
    public ObservableList<String> stringValue = FXCollections.observableArrayList();
    public ContextMenu menu;
    public MenuItem showMenu;


    private Media media;
    private  MediaPlayer mp;


    public void initialize() {

        //crearDirecotrio()

        listaCanciones.setBackground(new Background(new BackgroundFill(Color.valueOf("#ff000000"),null,null)));
        listaCanciones.setVisible(false);
        txtFieldLista.setVisible(false);
        txtFieldLista.setManaged(false);
        listaCanciones.getItems().addAll(stringValue);

        btnPause.setVisible(false);
    }

    /*public void crearDirecotrio() {
        if(!directorioInstalacion.exists()) {
            directorioInstalacion.mkdir();
        }
    }*/


    public void loadMusic(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("musica.fxml"));
        try {
            Main.mainScene.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void search(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("busqueda.fxml"));
        try {
            Main.mainScene.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void nombreLista(ActionEvent actionEvent) {
        txtFieldLista.setVisible(true);
        txtFieldLista.setManaged(!txtFieldLista.isManaged());
    }

    public void addValue(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            stringValue.add(txtFieldLista.getText());
            listaCanciones.setVisible(true);
            txtFieldLista.setManaged(true);
            listaCanciones.setItems(stringValue);
            txtFieldLista.setText("");
            txtFieldLista.setVisible(false);
            txtFieldLista.setManaged(!txtFieldLista.isManaged());
        }

    }

    public void deleteValue(ActionEvent actionEvent) {
       stringValue.remove(listaCanciones.getSelectionModel().getSelectedIndex());
    }

    public void editValue(MouseEvent mouseEvent) {
        listaCanciones.setEditable(true);
        listaCanciones.setCellFactory(TextFieldListCell.forListView());
    }


    public void playSong(ActionEvent actionEvent) {
        media = new Media(new File(userDir).toURI().toString());
        mp = new MediaPlayer(media);
        mp.play();
        btnPause.setVisible(true);
        btnPlay.setVisible(false);
    }

    public void pauseSong(ActionEvent actionEvent) {
        mp.play();

        MediaPlayer.Status currentStatus = mp.getStatus();

        if (currentStatus == MediaPlayer.Status.PLAYING) {
            btnPlay.setVisible(false);
            mp.pause();

        } else if (currentStatus == MediaPlayer.Status.PAUSED) {
            mp.play();
            btnPlay.setVisible(false);


        }
        mp.setOnPaused(() -> mp.getCurrentTime());
    }
}

