package com.aetherwars;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.cardcontainer.Deck;
import com.aetherwars.models.cardcontainer.Hand;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.*;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.game.Game;
import com.aetherwars.models.game.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.*;

import static com.aetherwars.enums.CharacterType.*;
import static com.aetherwars.enums.LVLSpell.LVLUP;

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

    /* Variables */
    private Game game;

    /* Functions, procedures */
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
        hoverImage.setVisible(false);
        hoverTitle.setVisible(false);
        hoverAttack.setVisible(false);
        hoverHealth.setVisible(false);
        hoverLevel.setVisible(false);
        hoverExp.setVisible(false);
        hoverType.setVisible(false);
        hoverDescription.setVisible(false);
    }

    public String formatBonus(int bonus) {
        if (bonus > 0) {
            return "+" + bonus;
        } else if (bonus < 0) {
            return "-" + bonus;
        } else {
            return "";
        }
    }

    public void showHand(int i, CardData cd) {
        Image image = new Image("com/aetherwars/" + cd.getImage());
        String info = "";
        if (cd instanceof Character) {
            Character c = (Character) cd;
            info = "ATK " + c.getBaseAtk() + "/HP " + c.getBaseHp();
        } else if (cd instanceof Spell) {
            Spell s = (Spell) cd;
            if (s instanceof LVL) {
                LVL l = (LVL) s;
                if (l.getType() == LVLUP) {
                    info = "LVLUP";
                } else {
                    info = "LVLDOWN";
                }
            } else if (s instanceof MORPH) {
                info = "MORPH";

            } else if (s instanceof PTN) {
                PTN p = (PTN) s;
                if (p.getAtkBonus() == 0) {
                    info = "HP" + formatBonus(p.getHpBonus());
                } else if (p.getHpBonus() == 0) {
                    info = "ATK" + formatBonus(p.getAtkBonus());
                } else {
                    /* Keduanya tidak nol */
                    info = "ATK" + formatBonus(p.getAtkBonus()) + "/HP" + formatBonus(p.getHpBonus());
                }
            } else if (s instanceof SWAP) {
                info = "ATK <-> HP";
            }
        }
        int manaCost = cd.getManaCost();
        if (i == 1) {
            hand1Rect.setVisible(true);
            hand1Mana.setVisible(true);
            hand1Info.setVisible(true);
            hand1Image.setVisible(true);
            hand1Mana.setText("MANA " + String.valueOf(manaCost));
            hand1Info.setText(info);
            hand1Image.setImage(image);
        } else if (i == 2) {
            hand2Rect.setVisible(true);
            hand2Mana.setVisible(true);
            hand2Info.setVisible(true);
            hand2Image.setVisible(true);
            hand2Mana.setText("MANA " + String.valueOf(manaCost));
            hand2Info.setText(info);
            hand2Image.setImage(image);
        } else if (i == 3) {
            hand3Rect.setVisible(true);
            hand3Mana.setVisible(true);
            hand3Info.setVisible(true);
            hand3Image.setVisible(true);
            hand3Mana.setText("MANA " + String.valueOf(manaCost));
            hand3Info.setText(info);
            hand3Image.setImage(image);
        } else if (i == 4) {
            hand4Rect.setVisible(true);
            hand4Mana.setVisible(true);
            hand4Info.setVisible(true);
            hand4Image.setVisible(true);
            hand4Mana.setText("MANA " + String.valueOf(manaCost));
            hand4Info.setText(info);
            hand4Image.setImage(image);
        } else if (i == 5) {
            hand5Rect.setVisible(true);
            hand5Mana.setVisible(true);
            hand5Info.setVisible(true);
            hand5Image.setVisible(true);
            hand5Mana.setText("MANA " + String.valueOf(manaCost));
            hand5Info.setText(info);
            hand5Image.setImage(image);
        }
    }

    public void renderHand(Hand h) {
        /* Ambil kartu-kartu dari hand */
        List<Card> cards = h.getCards();
        int currentHand = 1;
        for (Card c: cards) {
            /* Ambil CardData dari card */
            CardData cd = c.getCardData();
            showHand(currentHand, cd);
            currentHand ++;
        }
        /* Hide hand yang tidak diperlukan */
        while (currentHand <= 5) {
            hideHand(currentHand);
            currentHand ++;
        }
    }

    public String getType(Type t) {
        if (t.getCharacterType() == OVERWORLD) {
            return "Overworld";
        } else if (t.getCharacterType() == NETHER) {
            return "Nether";
        } else if (t.getCharacterType() == END) {
            return "End";
        }
        return "";
    }

    public void renderInformation(Card c) {
        CardData cd = c.getCardData();
        hoverImage.setVisible(true);
        hoverTitle.setVisible(true);
        hoverAttack.setVisible(true);
        hoverHealth.setVisible(true);
        hoverLevel.setVisible(true);
        hoverExp.setVisible(true);
        hoverType.setVisible(true);
        hoverDescription.setVisible(true);
        Image image = new Image("com/aetherwars/" + cd.getImage());
        hoverImage.setImage(image);
        hoverDescription.setText(cd.getDescription());
        hoverTitle.setText(cd.getName());
        /* Kondisi yang ditampilkan sesuai dengan kartu */
        if (cd instanceof Character) {
            Character ch = (Character) cd;
            hoverAttack.setText("ATK: " + ch.getBaseAtk());
            hoverHealth.setText("HP: " + ch.getBaseHp());
            hoverLevel.setText("Type: " + getType(ch.getType()));
            hoverExp.setVisible(false);
            hoverType.setVisible(false);
        } else if (cd instanceof Spell) {
            Spell s = (Spell) cd;
            if (s instanceof LVL) {
                LVL l = (LVL) s;
                String type = "";
                if (l.getType() == LVLUP) {
                    type = "Level up";
                } else {
                    type = "Level down";
                }
                hoverAttack.setText("Type: " + type);
                hoverHealth.setVisible(false);
                hoverLevel.setVisible(false);
                hoverExp.setVisible(false);
                hoverType.setVisible(false);
            } else if (s instanceof MORPH) {
                MORPH m = (MORPH) s;
                hoverAttack.setText("Type: Morph");
                hoverHealth.setVisible(false);
                hoverLevel.setVisible(false);
                hoverExp.setVisible(false);
                hoverType.setVisible(false);
            } else if (s instanceof PTN) {
                PTN p = (PTN) s;
                hoverAttack.setText("Type: Potion");
                hoverHealth.setText("ATKBonus: " + formatBonus(p.getAtkBonus()));
                hoverLevel.setText("HPBonus: " + formatBonus(p.getHpBonus()));
                hoverExp.setText("Duration: " + p.getDuration());
                hoverType.setVisible(false);
            } else if (s instanceof SWAP) {
                SWAP sw = (SWAP) s;
                hoverAttack.setText("Type: Swap");
                hoverHealth.setVisible(false);
                hoverLevel.setVisible(false);
                hoverExp.setVisible(false);
                hoverType.setVisible(false);
            }
        }
    }

    public void updateDeckManaLabel() {
        Player p = game.getPlayer();
        Deck d = p.getDeck();
        deckLabel.setText(String.valueOf(d.getCards().size()));
        manaLabel.setText(p.getMana() + "/" + Math.min(game.getState().getTurn(), 10));
    }

    /* Mulai controller */
    public void initialize() {
        /* Mulai game! */
        game = Game.getInstance();
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
        /* Render hand dari player sekarang */
        Player p = game.getPlayer();
        renderHand(p.getHand());
        /* Update deck dan mana label */
        updateDeckManaLabel();
    }

    public void click() {
        System.out.println("Hello World!");
    }

    public void enterHand1() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(0));
        hand1Rect.setStyle("-fx-stroke: #fec20c");
    }

    public void enterHand2() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(1));
        hand2Rect.setStyle("-fx-stroke: #fec20c");
    }

    public void enterHand3() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(2));
        hand3Rect.setStyle("-fx-stroke: #fec20c");
    }

    public void enterHand4() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(3));
        hand4Rect.setStyle("-fx-stroke: #fec20c");
    }

    public void enterHand5() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(4));
        hand5Rect.setStyle("-fx-stroke: #fec20c");
    }

    public void exitHand() {
        hideHoverInformation();
        hand1Rect.setStyle("");
        hand2Rect.setStyle("");
        hand3Rect.setStyle("");
        hand4Rect.setStyle("");
        hand5Rect.setStyle("");
    }

}
