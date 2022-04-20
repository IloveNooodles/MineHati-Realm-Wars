package com.aetherwars.models.activecard;


import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.card.spell.Spell;

public class ActiveSpell extends ActiveCard {
    private int activeDuration;
    private SpellEffect spellEffect;

    public ActiveSpell(Card card) {
        super(card);
        this.activeDuration = ((Spell) card).getDuration();
        this.spellEffect = ((Spell) card).getEffect();
    }

    public Spell getCard() {
        return (Spell) this.card;
    }

    public void updateActiveSpells() {
        activeDuration--;
    }

    public SpellEffect getSpellEffect() {
        return spellEffect;
    }

    public int getActiveDuration() {
        return activeDuration;
    }
}
