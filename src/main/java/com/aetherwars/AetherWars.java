package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.game.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.aetherwars.util.CSVReader;
import com.aetherwars.models.extras.Type;

public class AetherWars extends Application {
    public Game game;

    @Override
    public void start(Stage stage) {
        Text text = new Text();
        text.setText("Loading...");
        text.setX(50);
        text.setY(50);

        Group root = new Group();
        root.getChildren().add(text);

        Scene scene = new Scene(root, 1280, 720);

        stage.setTitle("Minecraft: Aether Wars");
        stage.setScene(scene);
        stage.show();

        try {
            game = Game.getInstance();
            System.out.print(game.getCards());
            text.setText(game.getCards());
        } catch (Exception e) {
            e.printStackTrace();
            text.setText("Failed to load cards: " + e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
