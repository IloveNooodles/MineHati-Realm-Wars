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

    public Card remove(int idx) throws Exception {
        if (cards.size() == 0) {
            throw new EmptyHandException();
        }
        else if (cards.size() <= idx) {
            throw new EmptySlotException();
        }
        Card temp = cards.get(idx);
        cards.remove(idx);
        return temp;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void activate(int hand_idx, int board_idx) throws EmptySlotException, BoardAlreadyFilledException {
//        ActiveCard active = this.remove(hand_idx).activate();
        ActiveCard active = cards.get(hand_idx).activate();
        if (active instanceof ActiveCharacter) {
            if (Game.getInstance().getPlayerBoard().get(board_idx).getName().equals("")) {
                /* Belum ada kartu di board_idx itu */
                Game.getInstance().getPlayerBoard().add(board_idx, (ActiveCharacter) active);
                cards.remove(hand_idx);
            } else {
                throw new BoardAlreadyFilledException();
            }
        } else if (active instanceof ActiveSpell) {
            ActiveCharacter character = Game.getInstance().getPlayerBoard().get(board_idx % Game.MAX_CARDS_ON_BOARD);
            if (!character.getName().equals("")) {
                character.addActiveSpell((ActiveSpell) active);
                cards.remove(hand_idx);
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

