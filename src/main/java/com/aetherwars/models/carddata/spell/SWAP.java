package com.aetherwars.models.carddata.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCharacter;

public class SWAP extends Spell {
    public SWAP(String name, String description, String image, int duration, int mana) {
        super(name, description, mana, SpellEffect.TEMPORARY, image);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void activateEffect(ActiveCharacter activeCharacter) {
        activeCharacter.swap();
    }
}

