package com.aetherwars.models.card.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;
import com.aetherwars.models.card.Character;

public class MORPH extends Spell {
    Character character;

    public MORPH(String name, String description, int mana, Character character, String image) {
        super(name, description, mana, SpellEffect.PERMANENT, image);
        this.character = character;
    }

    @Override
    public int getDuration() {
        return -1;
    }

    @Override
    public ActiveCard activate() {
        return new ActiveSpell(this);
    }

    public void activateEffect(ActiveCharacter character) {
        character.morph(this.character);
    }
}

