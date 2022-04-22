package com.aetherwars.models.carddata.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.carddata.CardData;

public abstract class Spell extends CardData {
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


    public abstract void activateEffect(ActiveCharacter activeCharacter);
}
