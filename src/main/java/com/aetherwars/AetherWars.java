package com.aetherwars;

import com.aetherwars.models.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AetherWars extends Application {
    public Game game;
    public static boolean testGUI = false;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/aetherwars/fxml/gui.fxml"));
        stage.setTitle("Minecraft: Aether Wars");
        stage.setScene(new Scene(root));
        stage.show();
//        Text text = new Text();
//        text.setText("Loading...");
//        text.setX(50);
//        text.setY(50);
//
//        Group root = new Group();
//        root.getChildren().add(text);
//
//        Scene scene = new Scene(root, 1280, 720);
//
//        stage.setTitle("Minecraft: Aether Wars");
//        stage.setScene(scene);
//        stage.show();
//
//        try {
//            game = Game.getInstance();
//            // TODO: Nanti apus soalnya ini buat debug doang
//            System.out.print(game.getCards());
//            text.setText(game.getCards());
//        } catch (Exception e) {
//            e.printStackTrace();
//            text.setText("Failed to load cards: " + e);
//        }
    }

    public static void main(String[] args) {
        try {
            if (testGUI) {
                launch();
            } else {
                System.out.println("Aether Wars");
                Game game = Game.getInstance();
                System.out.println("Aether Wars");
                // TODO: Nanti apus soalnya ini buat debug doang
                System.out.println("-------------------start game-------------------");
                do {
                    game.nextPhase();
                    System.out.println("-------------------next phase-------------------");
                } while (game.endGame() == -1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
