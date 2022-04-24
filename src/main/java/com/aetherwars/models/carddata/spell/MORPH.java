package com.aetherwars.models.carddata.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;
import com.aetherwars.models.carddata.Character;

public class MORPH extends Spell {
    Character character;

    public MORPH(String name, String description, String image, Character character, int mana) {
        super(name, description, mana, SpellEffect.PERMANENT, image);
        this.character = character;
    }

    @Override
    public int getDuration() {
        return -1;
    }

    public void activateEffect(ActiveCharacter character) {
        character.morph(this.character);
    }
}

