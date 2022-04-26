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

    /* Board milik Steve */
    /* Board A - Steve */
    @FXML
    private Rectangle boardSteveARect;
    @FXML
    private ImageView boardSteveASword;
    @FXML
    private ImageView boardSteveAHeart;
    @FXML
    private ImageView boardSteveAImage;
    @FXML
    private Label boardSteveAAttack;
    @FXML
    private Label boardSteveAHealth;
    @FXML
    private Label boardSteveALevel;
    @FXML
    private Label boardSteveALabel;
    /* Board B - Steve */
    @FXML
    private Rectangle boardSteveBRect;
    @FXML
    private ImageView boardSteveBSword;
    @FXML
    private ImageView boardSteveBHeart;
    @FXML
    private ImageView boardSteveBImage;
    @FXML
    private Label boardSteveBAttack;
    @FXML
    private Label boardSteveBHealth;
    @FXML
    private Label boardSteveBLevel;
    @FXML
    private Label boardSteveBLabel;
    /* Board C - Steve */
    @FXML
    private Rectangle boardSteveCRect;
    @FXML
    private ImageView boardSteveCSword;
    @FXML
    private ImageView boardSteveCHeart;
    @FXML
    private ImageView boardSteveCImage;
    @FXML
    private Label boardSteveCAttack;
    @FXML
    private Label boardSteveCHealth;
    @FXML
    private Label boardSteveCLevel;
    @FXML
    private Label boardSteveCLabel;
    /* Board D - Steve */
    @FXML
    private Rectangle boardSteveDRect;
    @FXML
    private ImageView boardSteveDSword;
    @FXML
    private ImageView boardSteveDHeart;
    @FXML
    private ImageView boardSteveDImage;
    @FXML
    private Label boardSteveDAttack;
    @FXML
    private Label boardSteveDHealth;
    @FXML
    private Label boardSteveDLevel;
    @FXML
    private Label boardSteveDLabel;
    /* Board E - Steve */
    @FXML
    private Rectangle boardSteveERect;
    @FXML
    private ImageView boardSteveESword;
    @FXML
    private ImageView boardSteveEHeart;
    @FXML
    private ImageView boardSteveEImage;
    @FXML
    private Label boardSteveEAttack;
    @FXML
    private Label boardSteveEHealth;
    @FXML
    private Label boardSteveELevel;
    @FXML
    private Label boardSteveELabel;

    /* Board milik Alex */
    /* Board A - Alex */
    @FXML
    private Rectangle boardAlexARect;
    @FXML
    private ImageView boardAlexASword;
    @FXML
    private ImageView boardAlexAHeart;
    @FXML
    private ImageView boardAlexAImage;
    @FXML
    private Label boardAlexAAttack;
    @FXML
    private Label boardAlexAHealth;
    @FXML
    private Label boardAlexALevel;
    @FXML
    private Label boardAlexALabel;
    /* Board B - Alex */
    @FXML
    private Rectangle boardAlexBRect;
    @FXML
    private ImageView boardAlexBSword;
    @FXML
    private ImageView boardAlexBHeart;
    @FXML
    private ImageView boardAlexBImage;
    @FXML
    private Label boardAlexBAttack;
    @FXML
    private Label boardAlexBHealth;
    @FXML
    private Label boardAlexBLevel;
    @FXML
    private Label boardAlexBLabel;
    /* Board C - Alex */
    @FXML
    private Rectangle boardAlexCRect;
    @FXML
    private ImageView boardAlexCSword;
    @FXML
    private ImageView boardAlexCHeart;
    @FXML
    private ImageView boardAlexCImage;
    @FXML
    private Label boardAlexCAttack;
    @FXML
    private Label boardAlexCHealth;
    @FXML
    private Label boardAlexCLevel;
    @FXML
    private Label boardAlexCLabel;
    /* Board D - Alex */
    @FXML
    private Rectangle boardAlexDRect;
    @FXML
    private ImageView boardAlexDSword;
    @FXML
    private ImageView boardAlexDHeart;
    @FXML
    private ImageView boardAlexDImage;
    @FXML
    private Label boardAlexDAttack;
    @FXML
    private Label boardAlexDHealth;
    @FXML
    private Label boardAlexDLevel;
    @FXML
    private Label boardAlexDLabel;
    /* Board E - Alex */
    @FXML
    private Rectangle boardAlexERect;
    @FXML
    private ImageView boardAlexESword;
    @FXML
    private ImageView boardAlexEHeart;
    @FXML
    private ImageView boardAlexEImage;
    @FXML
    private Label boardAlexEAttack;
    @FXML
    private Label boardAlexEHealth;
    @FXML
    private Label boardAlexELevel;
    @FXML
    private Label boardAlexELabel;

    /* Hand */
    /* Hand 1 */
    @FXML
    private Rectangle hand1Rect;
    @FXML
    private ImageView hand1Image;
    @FXML
    private Label hand1Mana;
    @FXML
    private Label hand1Info;
    /* Hand 2 */
    @FXML
    private Rectangle hand2Rect;
    @FXML
    private ImageView hand2Image;
    @FXML
    private Label hand2Mana;
    @FXML
    private Label hand2Info;
    /* Hand 3 */
    @FXML
    private Rectangle hand3Rect;
    @FXML
    private ImageView hand3Image;
    @FXML
    private Label hand3Mana;
    @FXML
    private Label hand3Info;
    /* Hand 4 */
    @FXML
    private Rectangle hand4Rect;
    @FXML
    private ImageView hand4Image;
    @FXML
    private Label hand4Mana;
    @FXML
    private Label hand4Info;
    /* Hand 5 */
    @FXML
    private Rectangle hand5Rect;
    @FXML
    private ImageView hand5Image;
    @FXML
    private Label hand5Mana;
    @FXML
    private Label hand5Info;

    /* Hover information */
    @FXML
    private ImageView hoverImage;
    @FXML
    private Label hoverTitle;
    @FXML
    private Label hoverAttack;
    @FXML
    private Label hoverHealth;
    @FXML
    private Label hoverLevel;
    @FXML
    private Label hoverExp;
    @FXML
    private Label hoverType;
    @FXML
    private Label hoverDescription;

    /* Deck information */
    @FXML
    private Label deckLabel;

    /* Mana information */
    @FXML
    private Label manaLabel;

    /* Next phase button */
    @FXML
    private Label nextPhase;

    public void hideSteveBoard(char board) {
        if (board == 'A') {
            boardSteveASword.setVisible(false);
            boardSteveAHeart.setVisible(false);
            boardSteveAImage.setVisible(false);
            boardSteveAAttack.setVisible(false);
            boardSteveAHealth.setVisible(false);
            boardSteveALevel.setVisible(false);
            boardSteveALabel.setVisible(true);
        } else if (board == 'B') {
            boardSteveBSword.setVisible(false);
            boardSteveBHeart.setVisible(false);
            boardSteveBImage.setVisible(false);
            boardSteveBAttack.setVisible(false);
            boardSteveBHealth.setVisible(false);
            boardSteveBLevel.setVisible(false);
            boardSteveBLabel.setVisible(true);
        } else if (board == 'C') {
            boardSteveCSword.setVisible(false);
            boardSteveCHeart.setVisible(false);
            boardSteveCImage.setVisible(false);
            boardSteveCAttack.setVisible(false);
            boardSteveCHealth.setVisible(false);
            boardSteveCLevel.setVisible(false);
            boardSteveCLabel.setVisible(true);
        } else if (board == 'D') {
            boardSteveDSword.setVisible(false);
            boardSteveDHeart.setVisible(false);
            boardSteveDImage.setVisible(false);
            boardSteveDAttack.setVisible(false);
            boardSteveDHealth.setVisible(false);
            boardSteveDLevel.setVisible(false);
            boardSteveDLabel.setVisible(true);
        } else if (board == 'E') {
            boardSteveESword.setVisible(false);
            boardSteveEHeart.setVisible(false);
            boardSteveEImage.setVisible(false);
            boardSteveEAttack.setVisible(false);
            boardSteveEHealth.setVisible(false);
            boardSteveELevel.setVisible(false);
            boardSteveELabel.setVisible(true);
        }
    }

    public void hideAlexBoard(char board) {
        if (board == 'A') {
            boardAlexASword.setVisible(false);
            boardAlexAHeart.setVisible(false);
            boardAlexAImage.setVisible(false);
            boardAlexAAttack.setVisible(false);
            boardAlexAHealth.setVisible(false);
            boardAlexALevel.setVisible(false);
            boardAlexALabel.setVisible(true);
        } else if (board == 'B') {
            boardAlexBSword.setVisible(false);
            boardAlexBHeart.setVisible(false);
            boardAlexBImage.setVisible(false);
            boardAlexBAttack.setVisible(false);
            boardAlexBHealth.setVisible(false);
            boardAlexBLevel.setVisible(false);
            boardAlexBLabel.setVisible(true);
        } else if (board == 'C') {
            boardAlexCSword.setVisible(false);
            boardAlexCHeart.setVisible(false);
            boardAlexCImage.setVisible(false);
            boardAlexCAttack.setVisible(false);
            boardAlexCHealth.setVisible(false);
            boardAlexCLevel.setVisible(false);
            boardAlexCLabel.setVisible(true);
        } else if (board == 'D') {
            boardAlexDSword.setVisible(false);
            boardAlexDHeart.setVisible(false);
            boardAlexDImage.setVisible(false);
            boardAlexDAttack.setVisible(false);
            boardAlexDHealth.setVisible(false);
            boardAlexDLevel.setVisible(false);
            boardAlexDLabel.setVisible(true);
        } else if (board == 'E') {
            boardAlexESword.setVisible(false);
            boardAlexEHeart.setVisible(false);
            boardAlexEImage.setVisible(false);
            boardAlexEAttack.setVisible(false);
            boardAlexEHealth.setVisible(false);
            boardAlexELevel.setVisible(false);
            boardAlexELabel.setVisible(true);
        }
    }

    public void setPhase(String phase) {
        if (phase.equals("DRAW")) {
            drawIndicator.setStyle("-fx-fill: #FFAB40");
            planIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            attackIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            endIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
        } else if (phase.equals("PLAN")) {
            drawIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            planIndicator.setStyle("-fx-fill: #FFAB40");
            attackIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            endIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
        } else if (phase.equals("ATTACK")) {
            drawIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            planIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            attackIndicator.setStyle("-fx-fill: #FFAB40");
            endIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
        } else if (phase.equals("END")) {
            drawIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            planIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            attackIndicator.setStyle("-fx-fill: rgba(0, 0, 0, 0)");
            endIndicator.setStyle("-fx-fill: #FFAB40");
        }
    }

    public void hideHand(int handNumber) {
        if (handNumber == 1) {
            hand1Image.setVisible(false);
            hand1Info.setVisible(false);
            hand1Mana.setVisible(false);
            hand1Rect.setVisible(false);
        } else if (handNumber == 2) {
            hand2Image.setVisible(false);
            hand2Info.setVisible(false);
            hand2Mana.setVisible(false);
            hand2Rect.setVisible(false);
        } else if (handNumber == 3) {
            hand3Image.setVisible(false);
            hand3Info.setVisible(false);
            hand3Mana.setVisible(false);
            hand3Rect.setVisible(false);
        } else if (handNumber == 4) {
            hand4Image.setVisible(false);
            hand4Info.setVisible(false);
            hand4Mana.setVisible(false);
            hand4Rect.setVisible(false);
        } else if (handNumber == 5) {
            hand5Image.setVisible(false);
            hand5Info.setVisible(false);
            hand5Mana.setVisible(false);
            hand5Rect.setVisible(false);
        }
    }

    public void hideHoverInformation() {
        hoverAttack.setVisible(false);
        hoverDescription.setVisible(false);
        hoverExp.setVisible(false);
        hoverHealth.setVisible(false);
        hoverImage.setVisible(false);
        hoverAttack.setVisible(false);
        hoverDescription.setVisible(false);
        hoverLevel.setVisible(false);
        hoverTitle.setVisible(false);
        hoverType.setVisible(false);
    }

    public void initialize() {
        /* Turn pertama adalah turn Steve */
        alexIndicator.setVisible(false);
        /* Clear decks */
        char[] boards = {'A', 'B', 'C', 'D', 'E'};
        for (char c : boards) {
            hideSteveBoard(c);
            hideAlexBoard(c);
        }
        int[] hands = {1, 2, 3, 4, 5};
        for (int i : hands) {
            hideHand(i);
        }
        /* Hide hover informations */
        hideHoverInformation();
        /* By default, mulai di phase draw */
        setPhase("DRAW");
    }

    public void click() {
        System.out.println("Hello World!");
    }

}
