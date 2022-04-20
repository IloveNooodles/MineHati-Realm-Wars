package com.aetherwars.models.cardcontainer;

import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.game.Game;

public class Board extends CardContainer<ActiveCharacter> {

    public Board() {

        super();
        for (int i = 0; i < Game.MAX_CARDS_ON_BOARD; i++) {
            this.add(new ActiveCharacter());
        }
    }

    public ActiveCharacter remove(int idx) {
        return cards.set(idx, new ActiveCharacter());
    }

    public void add(ActiveCharacter card) {
        for (int i = 0; i < Game.MAX_CARDS_ON_BOARD; i++) {
            if (cards.get(i).getName().equals("")) {
                cards.set(i, card);
                return;
            }
        }
        // TODO: Raise board is full exception
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ActiveCharacter card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }

    public void updateState() {
        for (int i = 0; i < Game.MAX_CARDS_ON_BOARD; i++) {
            cards.get(i).updateState();
        }
    }
}
