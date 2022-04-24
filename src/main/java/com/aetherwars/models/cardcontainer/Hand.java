package com.aetherwars.models.cardcontainer;

import com.aetherwars.models.activecard.*;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.game.Game;
import com.aetherwars.exception.*;

import java.util.List;


public class Hand extends CardContainer<Card> {
    public Hand() {
        super();
    }

    public Card remove(int idx) {
        Card temp = cards.get(idx);
        cards.remove(idx);
        return temp;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void activate(int hand_idx, int board_idx) throws Exception {
        ActiveCard active = this.remove(hand_idx).activate();
        if (active instanceof ActiveCharacter) {
            Game.getInstance().getPlayerBoard().add(board_idx, (ActiveCharacter) active);
        } else if (active instanceof ActiveSpell) {
            ActiveCharacter character = Game.getInstance().getBoards()[Math.floorDiv(board_idx,
                    Game.MAX_CARDS_ON_BOARD)].get(board_idx % Game.MAX_CARDS_ON_BOARD);
            if (!character.getName().equals("")) {
                character.addActiveSpell((ActiveSpell) active);
            } else {
                throw new EmptySlotException();
            }

        }
    }

    public String toString() {
        String res = "";
        for (Card card : cards) {
            res += card.getCardData().getName() + " " + card.getCardData().getManaCost() + "\n";
        }
        return res;
    }

    public List<Card> getCards() {
        return cards;
    }
}

