package com.aetherwars.models.card.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;

public class SWAP extends Spell {
    public SWAP(String name, String description, int mana, int duration, String image) {
        super(name, description, mana, SpellEffect.TEMPORARY, image);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public ActiveCard activate() {
        return new ActiveSpell(this);
    }

    @Override
    public void activateEffect(ActiveCharacter activeCharacter) {
        activeCharacter.swap();
    }
}

