package com.aetherwars.models.carddata;

import com.aetherwars.models.extras.Type;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;

public class Character extends CardData {
    private final Type type;
    private final int baseAtk;
    private final int baseHp;
    private final int atkUp;
    private final int hpUp;

    public Character() {
        super();
        this.type = null;
        this.baseAtk = 0;
        this.baseHp = 0;
        this.atkUp = 0;
        this.hpUp = 0;
    }

    public Character(String name, String description, Type type, String image, int baseAtk, int baseHp, int manaCost, int atkUp, int hpUp) {
        super(name, description, manaCost, image);
        this.type = type;
        this.baseAtk = baseAtk;
        this.baseHp = baseHp;
        this.name = name;
        this.atkUp = atkUp;
        this.hpUp = hpUp;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public int getAtkUp() {
        return atkUp;
    }

    public int getHpUp() {
        return hpUp;
    }

    public Type getType() {
        return type;
    }


    public String toString() {
        return "Character: " + name + " \n" + description + " \n" + type + " \n" + image + " \n" + baseAtk + " \n" + baseHp + " \n" + manaCost + " \n" + atkUp + " \n" + hpUp;
    }

}