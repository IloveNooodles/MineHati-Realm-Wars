package com.aetherwars.models.activecard;

import com.aetherwars.interfaces.Attackable;
import com.aetherwars.models.carddata.*;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.PTN;

import java.util.ArrayList;

public class ActiveCharacter extends ActiveCard implements Attackable {
    private int exp;
    private int level;
    private double atk;
    private double hp;
    private double maxHp;
    private ArrayList<ActiveSpell> activeSpells;
    private boolean hasAttacked;

    public ActiveCharacter() {
        super(new Character());
        this.exp = 0;
        this.level = 1;
        this.atk = 0;
        this.hp = 0;
        this.maxHp = 0;
        this.activeSpells = new ArrayList<ActiveSpell>();
        this.hasAttacked = false; // TODO : kalau udah ada ui, bisa diganti dengan disable button
    }

    public ActiveCharacter(CardData card) {
        super(card);
        this.exp = 0;
        this.level = 1;
        this.atk = this.getCard().getBaseAtk();
        this.hp = this.getCard().getBaseHp();
        this.maxHp = this.getCard().getBaseHp();
        this.activeSpells = new ArrayList<ActiveSpell>();
    }

    public void addExp(int addedExp) {
        if (addedExp > 0) {
            if (this.level < 10) {
                this.exp += addedExp;
                if (this.exp >= level * 2 - 1) {
                    this.levelUp();
                    int carry = addedExp - ((level - 1) * 2 - 1);
                    addExp(carry);
                }
            }
        }

    }

    public void attacked(ActiveCharacter attacker) {
        double attackingModifier = 1; // dari this ke musuh damagenya dikali berapa
        double attackedModifier = 1; // dari musuh ke this damagenya dikali berapa
        if (this.getCard().getType().compareTo(attacker.getCard().getType()) > 0) {
            attackingModifier = 2;
            attackedModifier = 0.5;
        } else if (this.getCard().getType().compareTo(attacker.getCard().getType()) < 0) {
            attackingModifier = 0.5;
            attackedModifier = 2;
        }
        this.hp -= attacker.getAtk() * attackedModifier;

        if (this.hp <= 0) {
            this.hp = 0;
        }

        attacker.hp -= this.atk * attackingModifier;
        if (this.hp <= 0) {
            attacker.addExp(this.level);
            this.die();
        }
        if (attacker.hp <= 0) {
            attacker.die();
        }
    }

    public Character getCard() {
        return (Character) card;
    }

    public String getName() {
        return this.getCard().getName();
    }

    public String getDescription() {
        return this.getCard().getDescription();
    }

    public double getAtk() {
        return atk;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getExp() {
        return exp;
    }

    public void addActiveSpell(ActiveSpell activeSpell) {
        switch (activeSpell.getSpellEffect()) {
            case PERMANENT:
                activeSpell.getCard().activateEffect(this);
                break;
            case TEMPORARY:
                activeSpell.getCard().activateEffect(this);
                activeSpells.add(activeSpell);
                break;
        }

        this.activeSpells.add(activeSpell);
    }

    public void updateState() {
        this.maxHp = this.getCard().getBaseHp() + (this.level - 1) * this.getCard().getHpUp();
        this.atk = this.getCard().getBaseAtk() + (this.level - 1) * this.getCard().getAtkUp();
        this.hasAttacked = false;

        for (int i = this.activeSpells.size() - 1; i > -1; i--) {
            this.activeSpells.get(i).activateEffect(this);
            if (this.activeSpells.get(i).getActiveDuration() <= 0) {
                this.activeSpells.remove(i);
            }
        }

        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }

        if (this.hp <= 0) {
            this.die();
        }
    }

    private void die() {
        // Masukin animasi mati :D
        this.morph(new Character());
    }

    public String toString() {
        return this.getName() + " lvl" + this.getLevel() + " exp: (" + this.getExp() + "/" + (level * 2 - 1) + ") hp: ("
                + this.getHp() + "/"
                + this.getMaxHp() + ") atk: " + this.getAtk();
    }

    public void morph(CardData card) {
        this.card = card;
        this.exp = 0;
        this.level = 1;
        this.atk = this.getCard().getBaseAtk();
        this.hp = this.getCard().getBaseHp();
        this.maxHp = this.getCard().getBaseHp();
    }

    public void levelUp() {
        if (this.level < 10) {
            this.exp = 0;
            this.level++;
            this.increaseStats(this.getCard().getAtkUp(), this.getCard().getHpUp());
            this.hp = this.maxHp;
        }
    }

    public void levelDown() {
        if (this.level > 1) {
            this.level--;
            this.exp = 0;
            this.increaseStats(-this.getCard().getAtkUp(), -this.getCard().getHpUp());
            if (this.hp > this.maxHp) {
                this.hp = this.maxHp;
            }
        }
    }

    public void swap() {
        double maxHp = this.maxHp;
        this.maxHp = this.atk;
        this.atk = maxHp;
    }

    public void increaseStats(double atk, double hp) {
        this.atk += atk;
        this.maxHp += hp;
    }

    public void attack(Attackable target) {
        if (!hasAttacked) { // TODO : kalau udah ada ui, bisa diganti dengan disable button
            target.attacked(this);
            this.hasAttacked = true;
        } else {
            System.out.println("sudah menyerang");
        }
    }

    public boolean hasAttacked() { // TODO : kalau udah ada ui, bisa diganti dengan disable button
        return this.hasAttacked;
    }
}