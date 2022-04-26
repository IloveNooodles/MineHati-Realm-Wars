package com.aetherwars;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.TurnPhase;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.cardcontainer.Board;
import com.aetherwars.models.cardcontainer.Deck;
import com.aetherwars.models.cardcontainer.Hand;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.*;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.game.Game;
import com.aetherwars.models.game.GameState;
import com.aetherwars.models.game.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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

    /* Drawing phase */
    @FXML
    private Rectangle drawOverlay;
    /* Draw card #1 */
    @FXML
    private Rectangle drawCard1Back;
    @FXML
    private ImageView drawCard1Image;
    @FXML
    private Label drawCard1Mana;
    @FXML
    private Label drawCard1Info;
    @FXML
    private Rectangle drawCard1;
    /* Draw card #2 */
    @FXML
    private Rectangle drawCard2Back;
    @FXML
    private ImageView drawCard2Image;
    @FXML
    private Label drawCard2Mana;
    @FXML
    private Label drawCard2Info;
    @FXML
    private Rectangle drawCard2;
    /* Draw card #2 */
    @FXML
    private Rectangle drawCard3Back;
    @FXML
    private ImageView drawCard3Image;
    @FXML
    private Label drawCard3Mana;
    @FXML
    private Label drawCard3Info;
    @FXML
    private Rectangle drawCard3;

    /* Steve and Alex */
    @FXML
    private ImageView steveImage;
    @FXML
    private ImageView alexImage;

    /* Variables */
    private Game game;
    private int selectedHand;
    private int selectedBoard;

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

    public void hideDrawOverlay() {
        drawOverlay.setVisible(false);
        drawCard1.setVisible(false);
        drawCard1Back.setVisible(false);
        drawCard1Image.setVisible(false);
        drawCard1Info.setVisible(false);
        drawCard1Mana.setVisible(false);
        drawCard2.setVisible(false);
        drawCard2Back.setVisible(false);
        drawCard2Image.setVisible(false);
        drawCard2Info.setVisible(false);
        drawCard2Mana.setVisible(false);
        drawCard3.setVisible(false);
        drawCard3Back.setVisible(false);
        drawCard3Image.setVisible(false);
        drawCard3Info.setVisible(false);
        drawCard3Mana.setVisible(false);
    }

    public void updateDeckManaLabel() {
        Player p = game.getPlayer();
        Deck d = p.getDeck();
        deckLabel.setText(String.valueOf(d.getCards().size()));
        manaLabel.setText(p.getMana() + "/" + Math.min(game.getState().getTurn(), 10));
    }

    public void showDrawCard(int cardID, CardData cd) {
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
        if (cardID == 1) {
            drawCard1.setVisible(true);
            drawCard1Back.setVisible(true);
            drawCard1Image.setVisible(true);
            drawCard1Info.setVisible(true);
            drawCard1Mana.setVisible(true);
            drawCard1Image.setImage(image);
            drawCard1Info.setText(info);
            drawCard1Mana.setText("MANA " + manaCost);
        } else if (cardID == 2) {
            drawCard2.setVisible(true);
            drawCard2Back.setVisible(true);
            drawCard2Image.setVisible(true);
            drawCard2Info.setVisible(true);
            drawCard2Mana.setVisible(true);
            drawCard2Image.setImage(image);
            drawCard2Info.setText(info);
            drawCard2Mana.setText("MANA " + manaCost);
        } else if (cardID == 3) {
            drawCard3.setVisible(true);
            drawCard3Back.setVisible(true);
            drawCard3Image.setVisible(true);
            drawCard3Info.setVisible(true);
            drawCard3Mana.setVisible(true);
            drawCard3Image.setImage(image);
            drawCard3Info.setText(info);
            drawCard3Mana.setText("MANA " + manaCost);
        }
    }

    public void initializeDrawOverlay() {
        drawOverlay.setVisible(true);
        /* Initialize ketiga card */
        int cardID = 1;
        while (cardID <= 3) {
            /* Ambil kartunya */
            CardData cd = game.getPlayer().getDeck().getCards().get(cardID - 1).getCardData();
            showDrawCard(cardID, cd);
            cardID ++;
        }
    }

    public void nextPhaseClicked() {
        GameState state = game.getState();
        if (state.getPhase() == TurnPhase.DRAW) {
            /* TODO: Perintahkan pemain untuk memilih card untuk dihapus sebelum draw */
            initializeDrawOverlay();
        } else if (state.getPhase() == TurnPhase.PLAN) {
            selectedHand = -1;
            resetHandFillColor();
            nextPhase();
            selectedBoard = -1;
        } else if (state.getPhase() == TurnPhase.ATTACK) {
            selectedBoard = -1;
            resetBoardFills();
            nextPhase();
        } else if (state.getPhase() == TurnPhase.END) {
            nextPhase();
            if (game.getState().getPlayerTurn() == 0) {
                /* Tambah mana dan update status board */
                game.nextTurn();
            }
            updateTurn();
            renderHand(game.getPlayer().getHand());
            renderBoards();
            updatePlayerIndicator();
            updateDeckManaLabel();
        }
    }

    public void enterHand1() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(0));
        hand1Rect.setStroke(Color.web("#fec20c"));
    }

    public void enterHand2() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(1));
        hand2Rect.setStroke(Color.web("#fec20c"));
    }

    public void enterHand3() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(2));
        hand3Rect.setStroke(Color.web("#fec20c"));
    }

    public void enterHand4() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(3));
        hand4Rect.setStroke(Color.web("#fec20c"));
    }

    public void enterHand5() {
        Player p = game.getPlayer();
        Hand h = p.getHand();
        List<Card> cards = h.getCards();
        renderInformation(cards.get(4));
        hand5Rect.setStroke(Color.web("#fec20c"));
    }

    public void exitHand() {
        hideHoverInformation();
        hand1Rect.setStroke(Color.web("#000000"));
        hand2Rect.setStroke(Color.web("#000000"));
        hand3Rect.setStroke(Color.web("#000000"));
        hand4Rect.setStroke(Color.web("#000000"));
        hand5Rect.setStroke(Color.web("#000000"));
    }

    public void hoverDraw1() {
        drawCard1.setStyle("-fx-stroke: #fec20c");
    }

    public void hoverDraw2() {
        drawCard2.setStyle("-fx-stroke: #fec20c");
    }

    public void hoverDraw3() {
        drawCard3.setStyle("-fx-stroke: #fec20c");
    }

    public void exitDraw() {
        drawCard1.setStyle("");
        drawCard2.setStyle("");
        drawCard3.setStyle("");
    }

    public void clickDraw1() throws Exception {
        game.getPlayer().draw(0);
        renderHand(game.getPlayer().getHand());
        updateDeckManaLabel();
        nextPhase();
        hideDrawOverlay();
    }

    public void clickDraw2() throws Exception {
        game.getPlayer().draw(1);
        renderHand(game.getPlayer().getHand());
        updateDeckManaLabel();
        nextPhase();
        hideDrawOverlay();
    }

    public void clickDraw3() throws Exception {
        game.getPlayer().draw(2);
        renderHand(game.getPlayer().getHand());
        updateDeckManaLabel();
        nextPhase();
        hideDrawOverlay();
    }

    public void nextPhase() {
        game.getState().nextPhase();
        TurnPhase phase = game.getState().getPhase();
        if (phase == TurnPhase.DRAW) {
            setPhase("DRAW");
        } else if (phase == TurnPhase.PLAN) {
            setPhase("PLAN");
        } else if (phase == TurnPhase.ATTACK) {
            setPhase("ATTACK");
        } else if (phase == TurnPhase.END) {
            setPhase("END");
        }
    }

    /* Pengaturan plan phase */
    public void resetHandFillColor() {
        if (selectedHand != 1) {
            hand1Rect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedHand != 2) {
            hand2Rect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedHand != 3) {
            hand3Rect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedHand != 4) {
            hand4Rect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedHand != 5) {
            hand5Rect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
    }

    public void clickHand1() {
        if (game.getState().getPhase() == TurnPhase.PLAN) {
            selectedHand = 1;
            hand1Rect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
            resetHandFillColor();
        }
    }

    public void clickHand2() {
        if (game.getState().getPhase() == TurnPhase.PLAN) {
            selectedHand = 2;
            hand2Rect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
            resetHandFillColor();
        }
    }

    public void clickHand3() {
        if (game.getState().getPhase() == TurnPhase.PLAN) {
            selectedHand = 3;
            hand3Rect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
            resetHandFillColor();
        }
    }

    public void clickHand4() {
        if (game.getState().getPhase() == TurnPhase.PLAN) {
            selectedHand = 4;
            hand4Rect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
            resetHandFillColor();
        }
    }

    public void clickHand5() {
        if (game.getState().getPhase() == TurnPhase.PLAN) {
            selectedHand = 5;
            hand5Rect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
            resetHandFillColor();
        }
    }

    public void exitBoard() {
        boardSteveARect.setStroke(Color.web("#000000"));
        boardSteveBRect.setStroke(Color.web("#000000"));
        boardSteveCRect.setStroke(Color.web("#000000"));
        boardSteveDRect.setStroke(Color.web("#000000"));
        boardSteveERect.setStroke(Color.web("#000000"));
        boardAlexARect.setStroke(Color.web("#000000"));
        boardAlexBRect.setStroke(Color.web("#000000"));
        boardAlexCRect.setStroke(Color.web("#000000"));
        boardAlexDRect.setStroke(Color.web("#000000"));
        boardAlexERect.setStroke(Color.web("#000000"));
    }

    public void enterASteve() {
        boardSteveARect.setStroke(Color.web("#fec20c"));
    }

    public void enterBSteve() {
        boardSteveBRect.setStroke(Color.web("#fec20c"));
    }

    public void enterCSteve() {
        boardSteveCRect.setStroke(Color.web("#fec20c"));
    }

    public void enterDSteve() {
        boardSteveDRect.setStroke(Color.web("#fec20c"));
    }

    public void enterESteve() {
        boardSteveERect.setStroke(Color.web("#fec20c"));
    }

    public void enterAAlex() {
        boardAlexARect.setStroke(Color.web("#fec20c"));
    }

    public void enterBAlex() {
        boardAlexBRect.setStroke(Color.web("#fec20c"));
    }

    public void enterCAlex() {
        boardAlexCRect.setStroke(Color.web("#fec20c"));
    }

    public void enterDAlex() {
        boardAlexDRect.setStroke(Color.web("#fec20c"));
    }

    public void enterEAlex() {
        boardAlexERect.setStroke(Color.web("#fec20c"));
    }

    public char boardNumberToChar(int i) {
        switch(i) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            default:
                return 'X';
        }
    }

    public void renderSteveBoard(int i, ActiveCharacter ac) {
        CardData cd = ac.getCard();
        Image image = new Image("com/aetherwars/" + cd.getImage());
        if (i == 0) {
            boardSteveASword.setVisible(true);
            boardSteveAHeart.setVisible(true);
            boardSteveAImage.setVisible(true);
            boardSteveAAttack.setVisible(true);
            boardSteveAHealth.setVisible(true);
            boardSteveALevel.setVisible(true);
            boardSteveALabel.setVisible(false);

            boardSteveAImage.setImage(image);
            boardSteveAAttack.setText(String.valueOf(ac.getAtk()));
            boardSteveAHealth.setText(String.valueOf(ac.getHp()));
            boardSteveALevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 1) {
            boardSteveBSword.setVisible(true);
            boardSteveBHeart.setVisible(true);
            boardSteveBImage.setVisible(true);
            boardSteveBAttack.setVisible(true);
            boardSteveBHealth.setVisible(true);
            boardSteveBLevel.setVisible(true);
            boardSteveBLabel.setVisible(false);

            boardSteveBImage.setImage(image);
            boardSteveBAttack.setText(String.valueOf(ac.getAtk()));
            boardSteveBHealth.setText(String.valueOf(ac.getHp()));
            boardSteveBLevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 2) {
            boardSteveCSword.setVisible(true);
            boardSteveCHeart.setVisible(true);
            boardSteveCImage.setVisible(true);
            boardSteveCAttack.setVisible(true);
            boardSteveCHealth.setVisible(true);
            boardSteveCLevel.setVisible(true);
            boardSteveCLabel.setVisible(false);

            boardSteveCImage.setImage(image);
            boardSteveCAttack.setText(String.valueOf(ac.getAtk()));
            boardSteveCHealth.setText(String.valueOf(ac.getHp()));
            boardSteveCLevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 3) {
            boardSteveDSword.setVisible(true);
            boardSteveDHeart.setVisible(true);
            boardSteveDImage.setVisible(true);
            boardSteveDAttack.setVisible(true);
            boardSteveDHealth.setVisible(true);
            boardSteveDLevel.setVisible(true);
            boardSteveDLabel.setVisible(false);

            boardSteveDImage.setImage(image);
            boardSteveDAttack.setText(String.valueOf(ac.getAtk()));
            boardSteveDHealth.setText(String.valueOf(ac.getHp()));
            boardSteveDLevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 4) {
            boardSteveESword.setVisible(true);
            boardSteveEHeart.setVisible(true);
            boardSteveEImage.setVisible(true);
            boardSteveEAttack.setVisible(true);
            boardSteveEHealth.setVisible(true);
            boardSteveELevel.setVisible(true);
            boardSteveELabel.setVisible(false);

            boardSteveEImage.setImage(image);
            boardSteveEAttack.setText(String.valueOf(ac.getAtk()));
            boardSteveEHealth.setText(String.valueOf(ac.getHp()));
            boardSteveELevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        }
    }

    public void renderAlexBoard(int i, ActiveCharacter ac) {
        CardData cd = ac.getCard();
        Image image = new Image("com/aetherwars/" + cd.getImage());
        if (i == 0) {
            boardAlexASword.setVisible(true);
            boardAlexAHeart.setVisible(true);
            boardAlexAImage.setVisible(true);
            boardAlexAAttack.setVisible(true);
            boardAlexAHealth.setVisible(true);
            boardAlexALevel.setVisible(true);
            boardAlexALabel.setVisible(false);

            boardAlexAImage.setImage(image);
            boardAlexAAttack.setText(String.valueOf(ac.getAtk()));
            boardAlexAHealth.setText(String.valueOf(ac.getHp()));
            boardAlexALevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 1) {
            boardAlexBSword.setVisible(true);
            boardAlexBHeart.setVisible(true);
            boardAlexBImage.setVisible(true);
            boardAlexBAttack.setVisible(true);
            boardAlexBHealth.setVisible(true);
            boardAlexBLevel.setVisible(true);
            boardAlexBLabel.setVisible(false);

            boardAlexBImage.setImage(image);
            boardAlexBAttack.setText(String.valueOf(ac.getAtk()));
            boardAlexBHealth.setText(String.valueOf(ac.getHp()));
            boardAlexBLevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 2) {
            boardAlexCSword.setVisible(true);
            boardAlexCHeart.setVisible(true);
            boardAlexCImage.setVisible(true);
            boardAlexCAttack.setVisible(true);
            boardAlexCHealth.setVisible(true);
            boardAlexCLevel.setVisible(true);
            boardAlexCLabel.setVisible(false);

            boardAlexCImage.setImage(image);
            boardAlexCAttack.setText(String.valueOf(ac.getAtk()));
            boardAlexCHealth.setText(String.valueOf(ac.getHp()));
            boardAlexCLevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 3) {
            boardAlexDSword.setVisible(true);
            boardAlexDHeart.setVisible(true);
            boardAlexDImage.setVisible(true);
            boardAlexDAttack.setVisible(true);
            boardAlexDHealth.setVisible(true);
            boardAlexDLevel.setVisible(true);
            boardAlexDLabel.setVisible(false);

            boardAlexDImage.setImage(image);
            boardAlexDAttack.setText(String.valueOf(ac.getAtk()));
            boardAlexDHealth.setText(String.valueOf(ac.getHp()));
            boardAlexDLevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        } else if (i == 4) {
            boardAlexESword.setVisible(true);
            boardAlexEHeart.setVisible(true);
            boardAlexEImage.setVisible(true);
            boardAlexEAttack.setVisible(true);
            boardAlexEHealth.setVisible(true);
            boardAlexELevel.setVisible(true);
            boardAlexELabel.setVisible(false);

            boardAlexEImage.setImage(image);
            boardAlexEAttack.setText(String.valueOf(ac.getAtk()));
            boardAlexEHealth.setText(String.valueOf(ac.getHp()));
            boardAlexELevel.setText(String.format("%d/%d [%d]", ac.getExp(), ac.getLevel() * 2 - 1, ac.getLevel()));
        }
    }

    public void renderBoards() {
        Board boardSteve = game.getBoards()[0];
        Board boardAlex = game.getBoards()[1];
        /* Render kartu milik Steve */
        ArrayList<ActiveCharacter> cardsSteve = boardSteve.getCards();
        for (int i = 0; i < 5; i ++) {
            ActiveCharacter ac = cardsSteve.get(i);
            if (ac.getName().equals("")) {
                hideSteveBoard(boardNumberToChar(i));
            } else {
                renderSteveBoard(i, ac);
            }
        }
        /* Render kartu milik Alex */
        ArrayList<ActiveCharacter> cardsAlex = boardAlex.getCards();
        for (int i = 0; i < 5; i ++) {
            ActiveCharacter ac = cardsAlex.get(i);
            if (ac.getName().equals("")) {
                hideAlexBoard(boardNumberToChar(i));
            } else {
                renderAlexBoard(i, ac);
            }
        }
    }

    public boolean hasSteveBoardAttacked(int i) {
        Board b;
        if (game.getState().getPlayerTurn() == 0) {
            b = game.getPlayerBoard();
        } else {
            b = game.getEnemyBoard();
        }
        return b.getCards().get(i).hasAttacked();
    }

    public boolean hasAlexBoardAttacked(int i) {
        Board b;
        if (game.getState().getPlayerTurn() == 0) {
            b = game.getEnemyBoard();
        } else {
            b = game.getPlayerBoard();
        }
        return b.getCards().get(i).hasAttacked();
    }

    public void resetBoardFills() {
        boardSteveARect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardSteveBRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardSteveCRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardSteveDRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardSteveERect.setFill(Color.web("rgba(0, 0, 0, 0)"));

        boardAlexARect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardAlexBRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardAlexCRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardAlexDRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        boardAlexERect.setFill(Color.web("rgba(0, 0, 0, 0)"));
    }

    public void resetSteveBoardFill() {
        if (selectedBoard != 1 && !hasSteveBoardAttacked(0)) {
            boardSteveARect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 2 && !hasSteveBoardAttacked(1)) {
            boardSteveBRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 3 && !hasSteveBoardAttacked(2)) {
            boardSteveCRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 4 && !hasSteveBoardAttacked(3)) {
            boardSteveDRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 5 && !hasSteveBoardAttacked(4)) {
            boardSteveERect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
    }

    public void resetAlexBoardFill() {
        if (selectedBoard != 1 && !hasAlexBoardAttacked(0)) {
            boardAlexARect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 2 && !hasAlexBoardAttacked(1)) {
            boardAlexBRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 3 && !hasAlexBoardAttacked(2)) {
            boardAlexCRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 4 && !hasAlexBoardAttacked(3)) {
            boardAlexDRect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
        if (selectedBoard != 5 && !hasAlexBoardAttacked(4)) {
            boardAlexERect.setFill(Color.web("rgba(0, 0, 0, 0)"));
        }
    }

    public void clickASteve() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 0) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 0);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 0) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(0);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 1;
                    resetSteveBoardFill();
                    boardSteveARect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickBSteve() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 0) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 1);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 0) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(1);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 2;
                    resetSteveBoardFill();
                    boardSteveBRect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickCSteve() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 0) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 2);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 0) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(2);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 3;
                    resetSteveBoardFill();
                    boardSteveCRect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickDSteve() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 0) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 3);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 0) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(3);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 4;
                    resetSteveBoardFill();
                    boardSteveDRect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickESteve() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 0) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 4);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 0) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(4);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 5;
                    resetSteveBoardFill();
                    boardSteveERect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickAAlex() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 1) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 0);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 1) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(0);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 1;
                    resetAlexBoardFill();
                    boardAlexARect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickBAlex() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 1) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 1);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 1) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(1);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 2;
                    resetAlexBoardFill();
                    boardAlexBRect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickCAlex() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 1) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 2);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 1) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(2);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 3;
                    resetAlexBoardFill();
                    boardAlexCRect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickDAlex() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 1) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 3);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 1) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(3);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 4;
                    resetAlexBoardFill();
                    boardAlexDRect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void clickEAlex() {
        if (game.getState().getPhase() == TurnPhase.PLAN && game.getState().getPlayerTurn() == 1) {
            if (selectedHand != -1) {
                try {
                    game.getPlayer().play(selectedHand - 1, 4);
                    renderBoards();
                    renderHand(game.getPlayer().getHand());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    selectedHand = -1;
                    resetHandFillColor();
                    updateDeckManaLabel();
                }
            }
        }
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 1) {
                /* Memilih kartu untuk menyerang */
                /* Cek apakah kartu ini ada isinya atau tidak */
                ActiveCharacter ac = game.getPlayerBoard().getCards().get(4);
                if (!ac.getCard().getName().equals("") && !ac.hasAttacked()) {
                    selectedBoard = 5;
                    resetAlexBoardFill();
                    boardAlexERect.setFill(Color.web("rgba(0, 222, 0, 0.3)"));
                }
            }
        }
    }

    public void enterAlex() {
        alexImage.setStyle("-fx-opacity: 0.5");
    }

    public void enterSteve() {
        steveImage.setStyle("-fx-opacity: 0.5");
    }

    public void exitAlex() {
        alexImage.setStyle("");
    }

    public void exitSteve() {
        steveImage.setStyle("");
    }

    public void updateHP() {
        if (game.getState().getPlayerTurn() == 0) {
            pbSteve.setProgress((double) game.getPlayer().getHp() / 80);
            pbAlex.setProgress((double) game.getEnemy().getHp() / 80);
            lbSteve.setText(String.format("Steve [%d]", game.getPlayer().getHp()));
            lbAlex.setText(String.format("Alex [%d]", game.getEnemy().getHp()));
        } else {
            pbSteve.setProgress((double) game.getEnemy().getHp() / 80);
            pbAlex.setProgress((double) game.getPlayer().getHp() / 80);
            lbSteve.setText(String.format("Steve [%d]", game.getEnemy().getHp()));
            lbAlex.setText(String.format("Alex [%d]", game.getPlayer().getHp()));
        }
    }

    public void setSteveAttacked(int i) {
        if (i == 1) {
            boardSteveARect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 2) {
            boardSteveBRect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 3) {
            boardSteveCRect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 4) {
            boardSteveDRect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 5) {
            boardSteveERect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        }
    }

    public void setAlexAttacked(int i) {
        if (i == 1) {
            boardAlexARect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 2) {
            boardAlexBRect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 3) {
            boardAlexCRect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 4) {
            boardAlexDRect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        } else if (i == 5) {
            boardAlexERect.setFill(Color.web("rgba(222, 0, 0, 0.3)"));
        }
    }

    public void clickAlex() {
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 0) {
                if (selectedBoard != -1) {
                    game.getPlayer().attack(selectedBoard - 1, -1);
                    setSteveAttacked(selectedBoard);
                    selectedBoard = -1;
                    resetSteveBoardFill();
                    updateHP();
                }
            }
        }
    }

    public void clickSteve() {
        if (game.getState().getPhase() == TurnPhase.ATTACK) {
            if (game.getState().getPlayerTurn() == 1) {
                if (selectedBoard != -1) {
                    game.getPlayer().attack(selectedBoard - 1, -1);
                    setAlexAttacked(selectedBoard);
                    selectedBoard = -1;
                    resetAlexBoardFill();
                    updateHP();
                }
            }
        }
    }

    public void updatePlayerIndicator() {
        if (game.getState().getPlayerTurn() == 0) {
            alexIndicator.setVisible(false);
            steveIndicator.setVisible(true);
        } else {
            alexIndicator.setVisible(true);
            steveIndicator.setVisible(false);
        }
    }

    public void updateTurn() {
        turnNumber.setText(String.valueOf(game.getState().getTurn()));
    }

    /* Mulai controller */
    public void initialize() {
        /* Mulai game! */
        game = Game.getInstance();
        updateTurn();
        updatePlayerIndicator();
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
        /* Hide draw overlay */
        hideDrawOverlay();
        /* Belum memilih hand */
        selectedHand = -1;
        /* Inisialisasi progress bar */
        updateHP();
    }
}
