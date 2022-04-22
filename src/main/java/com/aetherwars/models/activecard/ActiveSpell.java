package com.aetherwars.models.activecard;


import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.carddata.spell.Spell;

public class ActiveSpell extends ActiveCard {
    private int activeDuration;
    private SpellEffect spellEffect;

    public ActiveSpell(CardData card) {
        super(card);
        this.activeDuration = ((Spell) card).getDuration();
        this.spellEffect = ((Spell) card).getEffect();
    }

    public Spell getCard() {
        return (Spell) this.card;
    }

    public void activateEffect(ActiveCharacter activeCharacter) {
        this.getCard().activateEffect(activeCharacter);
        activeDuration--;
    }

    public SpellEffect getSpellEffect() {
        return spellEffect;
    }

    public int getActiveDuration() {
        return activeDuration;
    }
}
