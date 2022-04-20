package com.aetherwars.models.card.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.card.Card;

public abstract class Spell extends Card {
    protected int mana;
    protected SpellEffect effect;
    protected int duration;

    public Spell(String name, String description, int mana, SpellEffect effect, String image) {
        super(name, description, mana, image);
        this.effect = effect;
    }

    public SpellEffect getEffect() {
        return effect;
    }

    public abstract int getDuration();

    public abstract ActiveCard activate();

    public void activateEffect(ActiveCharacter activeCharacter) {
        // Semi Abstract Method
        return;
    };
}
