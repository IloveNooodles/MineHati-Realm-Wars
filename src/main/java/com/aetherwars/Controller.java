package com.aetherwars;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Controller {
    /* HP bar untuk Steve dan Alex */
    @FXML
    private ProgressBar pbSteve;
    @FXML
    private ProgressBar pbAlex;

    /* Turn number */
    @FXML
    private Label turnNumber;

    /* Health indicator untuk Steve dan Alex */
    @FXML
    private Label lbSteve;
    @FXML
    private Label lbAlex;

    /* Indikator sekarang turn siapa */
    @FXML
    private Rectangle steveIndicator;
    @FXML
    private Rectangle alexIndicator;

    /* Indikator sekarang ada di phase apa */
    @FXML
    private Rectangle drawIndicator;
    @FXML
    private Rectangle planIndicator;
    @FXML
    private Rectangle attackIndicator;
    @FXML
    private Rectangle endIndicator;

    /* Deck milik Steve */
    /* Deck A - Steve */
    @FXML
    private Rectangle deckSteveARect;
    @FXML
    private ImageView deckSteveASword;
    @FXML
    private ImageView deckSteveAHeart;
    @FXML
    private ImageView deckSteveAImage;
    @FXML
    private Label deckSteveAAttack;
    @FXML
    private Label deckSteveAHealth;
    @FXML
    private Label deckSteveALevel;
    @FXML
    private Label deckSteveALabel;
    /* Deck B - Steve */
    @FXML
    private Rectangle deckSteveBRect;
    @FXML
    private ImageView deckSteveBSword;
    @FXML
    private ImageView deckSteveBHeart;
    @FXML
    private ImageView deckSteveBImage;
    @FXML
    private Label deckSteveBAttack;
    @FXML
    private Label deckSteveBHealth;
    @FXML
    private Label deckSteveBLevel;
    @FXML
    private Label deckSteveBLabel;
    /* Deck C - Steve */
    @FXML
    private Rectangle deckSteveCRect;
    @FXML
    private ImageView deckSteveCSword;
    @FXML
    private ImageView deckSteveCHeart;
    @FXML
    private ImageView deckSteveCImage;
    @FXML
    private Label deckSteveCAttack;
    @FXML
    private Label deckSteveCHealth;
    @FXML
    private Label deckSteveCLevel;
    @FXML
    private Label deckSteveCLabel;
    /* Deck D - Steve */
    @FXML
    private Rectangle deckSteveDRect;
    @FXML
    private ImageView deckSteveDSword;
    @FXML
    private ImageView deckSteveDHeart;
    @FXML
    private ImageView deckSteveDImage;
    @FXML
    private Label deckSteveDAttack;
    @FXML
    private Label deckSteveDHealth;
    @FXML
    private Label deckSteveDLevel;
    @FXML
    private Label deckSteveDLabel;
    /* Deck E - Steve */
    @FXML
    private Rectangle deckSteveERect;
    @FXML
    private ImageView deckSteveESword;
    @FXML
    private ImageView deckSteveEHeart;
    @FXML
    private ImageView deckSteveEImage;
    @FXML
    private Label deckSteveEAttack;
    @FXML
    private Label deckSteveEHealth;
    @FXML
    private Label deckSteveELevel;
    @FXML
    private Label deckSteveELabel;

    /* Deck milik Alex */
    /* Deck A - Alex */
    @FXML
    private Rectangle deckAlexARect;
    @FXML
    private ImageView deckAlexASword;
    @FXML
    private ImageView deckAlexAHeart;
    @FXML
    private ImageView deckAlexAImage;
    @FXML
    private Label deckAlexAAttack;
    @FXML
    private Label deckAlexAHealth;
    @FXML
    private Label deckAlexALevel;
    @FXML
    private Label deckAlexALabel;
    /* Deck B - Alex */
    @FXML
    private Rectangle deckAlexBRect;
    @FXML
    private ImageView deckAlexBSword;
    @FXML
    private ImageView deckAlexBHeart;
    @FXML
    private ImageView deckAlexBImage;
    @FXML
    private Label deckAlexBAttack;
    @FXML
    private Label deckAlexBHealth;
    @FXML
    private Label deckAlexBLevel;
    @FXML
    private Label deckAlexBLabel;
    /* Deck C - Alex */
    @FXML
    private Rectangle deckAlexCRect;
    @FXML
    private ImageView deckAlexCSword;
    @FXML
    private ImageView deckAlexCHeart;
    @FXML
    private ImageView deckAlexCImage;
    @FXML
    private Label deckAlexCAttack;
    @FXML
    private Label deckAlexCHealth;
    @FXML
    private Label deckAlexCLevel;
    @FXML
    private Label deckAlexCLabel;
    /* Deck D - Alex */
    @FXML
    private Rectangle deckAlexDRect;
    @FXML
    private ImageView deckAlexDSword;
    @FXML
    private ImageView deckAlexDHeart;
    @FXML
    private ImageView deckAlexDImage;
    @FXML
    private Label deckAlexDAttack;
    @FXML
    private Label deckAlexDHealth;
    @FXML
    private Label deckAlexDLevel;
    @FXML
    private Label deckAlexDLabel;
    /* Deck E - Alex */
    @FXML
    private Rectangle deckAlexERect;
    @FXML
    private ImageView deckAlexESword;
    @FXML
    private ImageView deckAlexEHeart;
    @FXML
    private ImageView deckAlexEImage;
    @FXML
    private Label deckAlexEAttack;
    @FXML
    private Label deckAlexEHealth;
    @FXML
    private Label deckAlexELevel;
    @FXML
    private Label deckAlexELabel;

    @FXML
    private Label myLabel;

    public void hideSteveDeck(char deck) {
        if (deck == 'A') {
            deckSteveASword.setVisible(false);
            deckSteveAHeart.setVisible(false);
            deckSteveAImage.setVisible(false);
            deckSteveAAttack.setVisible(false);
            deckSteveAHealth.setVisible(false);
            deckSteveALevel.setVisible(false);
            deckSteveALabel.setVisible(true);
        } else if (deck == 'B') {
            deckSteveBSword.setVisible(false);
            deckSteveBHeart.setVisible(false);
            deckSteveBImage.setVisible(false);
            deckSteveBAttack.setVisible(false);
            deckSteveBHealth.setVisible(false);
            deckSteveBLevel.setVisible(false);
            deckSteveBLabel.setVisible(true);
        } else if (deck == 'C') {
            deckSteveCSword.setVisible(false);
            deckSteveCHeart.setVisible(false);
            deckSteveCImage.setVisible(false);
            deckSteveCAttack.setVisible(false);
            deckSteveCHealth.setVisible(false);
            deckSteveCLevel.setVisible(false);
            deckSteveCLabel.setVisible(true);
        } else if (deck == 'D') {
            deckSteveDSword.setVisible(false);
            deckSteveDHeart.setVisible(false);
            deckSteveDImage.setVisible(false);
            deckSteveDAttack.setVisible(false);
            deckSteveDHealth.setVisible(false);
            deckSteveDLevel.setVisible(false);
            deckSteveDLabel.setVisible(true);
        } else if (deck == 'E') {
            deckSteveESword.setVisible(false);
            deckSteveEHeart.setVisible(false);
            deckSteveEImage.setVisible(false);
            deckSteveEAttack.setVisible(false);
            deckSteveEHealth.setVisible(false);
            deckSteveELevel.setVisible(false);
            deckSteveELabel.setVisible(true);
        }
    }

    public void hideAlexDeck(char deck) {
        if (deck == 'A') {
            deckAlexASword.setVisible(false);
            deckAlexAHeart.setVisible(false);
            deckAlexAImage.setVisible(false);
            deckAlexAAttack.setVisible(false);
            deckAlexAHealth.setVisible(false);
            deckAlexALevel.setVisible(false);
            deckAlexALabel.setVisible(true);
        } else if (deck == 'B') {
            deckAlexBSword.setVisible(false);
            deckAlexBHeart.setVisible(false);
            deckAlexBImage.setVisible(false);
            deckAlexBAttack.setVisible(false);
            deckAlexBHealth.setVisible(false);
            deckAlexBLevel.setVisible(false);
            deckAlexBLabel.setVisible(true);
        } else if (deck == 'C') {
            deckAlexCSword.setVisible(false);
            deckAlexCHeart.setVisible(false);
            deckAlexCImage.setVisible(false);
            deckAlexCAttack.setVisible(false);
            deckAlexCHealth.setVisible(false);
            deckAlexCLevel.setVisible(false);
            deckAlexCLabel.setVisible(true);
        } else if (deck == 'D') {
            deckAlexDSword.setVisible(false);
            deckAlexDHeart.setVisible(false);
            deckAlexDImage.setVisible(false);
            deckAlexDAttack.setVisible(false);
            deckAlexDHealth.setVisible(false);
            deckAlexDLevel.setVisible(false);
            deckAlexDLabel.setVisible(true);
        } else if (deck == 'E') {
            deckAlexESword.setVisible(false);
            deckAlexEHeart.setVisible(false);
            deckAlexEImage.setVisible(false);
            deckAlexEAttack.setVisible(false);
            deckAlexEHealth.setVisible(false);
            deckAlexELevel.setVisible(false);
            deckAlexELabel.setVisible(true);
        }
    }

    public void initialize() {
        /* Turn pertama adalah turn Steve */
        alexIndicator.setVisible(false);
        /* Clear decks */
        char[] decks = {'A', 'B', 'C', 'D', 'E'};
        for (char c : decks) {
            hideSteveDeck(c);
            hideAlexDeck(c);
        }
    }

    public void click() {
        myLabel.setVisible(false);
        System.out.println("Hello World!");
    }

}
