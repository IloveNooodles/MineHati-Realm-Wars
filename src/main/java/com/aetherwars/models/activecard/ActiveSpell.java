package com.aetherwars.models.activecard;


import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.carddata.spell.Spell;

public class ActiveSpell extends ActiveCard {
    private final SpellEffect spellEffect;
    private int activeDuration;

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
        decrementActiveDuration();
    }

    public SpellEffect getSpellEffect() {
        return spellEffect;
    }

    public int getActiveDuration() {
        return activeDuration;
    }

    public void decrementActiveDuration() {
        this.activeDuration--;
    }
}
