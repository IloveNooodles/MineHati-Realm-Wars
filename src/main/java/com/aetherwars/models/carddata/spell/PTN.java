package com.aetherwars.models.carddata.spell;

import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;

public class PTN extends Spell {
    private final int atkBonus;
    private final int hpBonus;

    public PTN(String name, String description, int mana, int duration, int atkBonus, int hpBonus, String image) {
        super(name, description, mana, SpellEffect.TEMPORARY, image);
        this.atkBonus = atkBonus;
        this.hpBonus = hpBonus;
        this.duration = duration;
    }

    public int getAtkBonus() {
        return atkBonus;
    }

    public int getHpBonus() {
        return hpBonus;
    }

    @Override
    public int getDuration() {
        return duration;
    }


    @Override
    public void activateEffect(ActiveCharacter activeCharacter) {
        activeCharacter.increaseStats(atkBonus, hpBonus);
    }

}
