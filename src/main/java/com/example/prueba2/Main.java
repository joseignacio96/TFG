package com.example.prueba2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    public static BorderPane mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainView.fxml"));
        mainScene = fxmlLoader.load();
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("musica.fxml"));
        mainScene.setCenter(fxmlLoader1.load());
        Scene scene = new Scene(mainScene);
        stage.setMinHeight(757);
        stage.setMinWidth(1133);
        stage.initStyle(StageStyle.UNIFIED);
        stage.setTitle("Musik");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon/icon.png")));
        stage.setScene(scene);
        stage.show();

        mainScene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        mainScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}