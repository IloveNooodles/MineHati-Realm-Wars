package com.aetherwars.models.activecard;

import com.aetherwars.models.card.Card;

public abstract class ActiveCard {
    Card card;

    public ActiveCard(Card card) {
        this.card = card;
    }
}

