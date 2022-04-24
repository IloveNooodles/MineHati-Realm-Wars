package com.aetherwars.models.cardcontainer;

import com.aetherwars.exception.BoardFullException;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.game.Game;

public class Board extends CardContainer<ActiveCharacter> {

    public Board() {
        super();
        for (int i = 0; i < Game.MAX_CARDS_ON_BOARD; i++) {
            this.cards.add(new ActiveCharacter());
        }
    }

    public ActiveCharacter remove(int idx) {
        return cards.set(idx, new ActiveCharacter());
    }

    public void add(ActiveCharacter card) throws Exception {
        for (int i = 0; i < Game.MAX_CARDS_ON_BOARD; i++) {
            if (cards.get(i).getName().equals("")) {
                cards.set(i, card);
                return;
            }
        }
        throw new BoardFullException();
    }

    public void add(int idx, ActiveCharacter card) {
        cards.set(idx, card);
    }

    public String toString() {
        String res = "";
        for (ActiveCharacter card : cards) {
            res += card.toString() + "\n";
        }
        return res;
    }

    public boolean isEmpty() {
        for (ActiveCharacter card : cards) {
            if (!card.getName().equals("")) {
                return false;
            }
        }
        return true;
    }

    public void updateState() {
        for (int i = 0; i < Game.MAX_CARDS_ON_BOARD; i++) {
            cards.get(i).updateState();
        }
    }
}
