package com.aetherwars.models.card;

import com.aetherwars.models.extras.Type;
import com.aetherwars.models.activecard.ActiveCard;
import com.aetherwars.models.activecard.ActiveCharacter;

public class Character extends Card {
    private Type type;
    private int baseAtk;
    private int baseHp;
    private int atkUp;
    private int hpUp;

    public Character() {
        super();
        this.type = null;
        this.baseAtk = 0;
        this.baseHp = 0;
        this.atkUp = 0;
        this.hpUp = 0;
    }

    public Character(String name, String description, Type type,String image, int baseAtk, int baseHp,int manaCost, int atkUp, int hpUp) {
        super(name, description, manaCost,image);
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

    public ActiveCard activate() {
        return new ActiveCharacter(this);
    }

    public String toString(){
        return this.name;
    }

}