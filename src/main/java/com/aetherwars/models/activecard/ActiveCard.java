package com.aetherwars.models.activecard;

import com.aetherwars.models.carddata.CardData;

public abstract class ActiveCard {
    CardData card;

    public ActiveCard(CardData card) {
        this.card = card;
    }
}

