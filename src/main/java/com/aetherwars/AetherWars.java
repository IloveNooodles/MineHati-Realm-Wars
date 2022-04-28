package com.aetherwars;

import com.aetherwars.models.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AetherWars extends Application {
    public Game game;
    public static boolean testGUI = true;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/aetherwars/fxml/gui.fxml"));
        stage.setTitle("Minecraft: Aether Wars");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
