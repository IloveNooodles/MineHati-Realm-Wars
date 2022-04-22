package com.aetherwars.models.cardcontainer;

import com.aetherwars.models.activecard.*;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.game.Game;


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

    public void activate(int hand_idx, int board_idx) {
        ActiveCard active = this.remove(hand_idx).activate();
        if (active instanceof ActiveCharacter) {
            Game.getInstance().getPlayerBoard().add((ActiveCharacter) active);
        } else if (active instanceof ActiveSpell) {
            ActiveCharacter character = Game.getInstance().getBoards()[Math.floorDiv(board_idx,
                    Game.MAX_CARDS_ON_BOARD)].get(board_idx % Game.MAX_CARDS_ON_BOARD);
            if (!character.getName().equals("")) {
                character.addActiveSpell((ActiveSpell) active);
            } else {
                // TODO: Raise selected board slot is empty exception
            }

        }
    }
}

