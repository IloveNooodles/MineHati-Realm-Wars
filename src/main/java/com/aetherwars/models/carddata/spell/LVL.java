package com.aetherwars.models.carddata.spell;

import com.aetherwars.enums.LVLSpell;
import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;

public class LVL extends Spell {
    private final LVLSpell type;

    public LVL(String name, String description, String image, LVLSpell type) {
        super(name, description, 0, SpellEffect.PERMANENT, image);
        this.type = type;
    }

    public LVLSpell getType() {
        return type;
    }

    @Override
    public int getDuration() {
        return -1;
    }


    public void activateEffect(ActiveCharacter character) {
        switch (type) {
            case LVLUP:
                character.levelUp();
                break;
            case LVLDOWN:
                character.levelDown();
                break;
        }
    }
}

