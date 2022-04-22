package com.aetherwars.models.card;

import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.Spell;

public class Card {
    private CardData data;

    public Card(CardData data) {
        this.data = data;
    }

    public CardData getCardData() {
        return this.data;
    }

    public ActiveCard activate() {
        if (this.data instanceof Character) {
            return new ActiveCharacter(this.data);
        } else {
            return new ActiveSpell(this.data);
        }
    }

}
