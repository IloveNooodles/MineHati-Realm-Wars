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

    public ActiveCharacter() {
        super(new Character());
        this.exp = 0;
        this.level = 1;
        this.atk = 0;
        this.hp = 0;
        this.maxHp = 0;
        this.activeSpells = new ArrayList<ActiveSpell>();
    }

    public ActiveCharacter(CardData card) {
        super(card);
        this.exp = 0;
        this.level = 1;
        this.atk = this.getCard().getBaseAtk();
        this.hp = this.getCard().getBaseHp();
        this.maxHp = this.getCard().getBaseHp();
    }

    public void addExp(int exp) {
        if (this.level < 10) {
            this.exp += exp;
            if (this.exp >= level * 2 - 1) {
                this.levelUp();
            }
        }
    }

    public void attacked(ActiveCharacter attacker) {
        this.hp -= attacker.getAtk(); //TODO: Tambah modifier

        if (this.hp <= 0) {
            this.hp = 0;
        }

        attacker.hp -= this.atk; // TODO: Tambah modifier
        if (attacker.hp <= 0) {
            attacker.hp = 0;
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
        int bonusAtk = 0;
        for (ActiveSpell activeSpell : this.activeSpells) {
            if (activeSpell.card instanceof PTN) {
                bonusAtk += ((PTN) activeSpell.card).getAtkBonus();
            }
        }
        return atk + bonusAtk;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void addActiveSpell(ActiveSpell activeSpell) {
        switch (activeSpell.getSpellEffect()) {
            case PERMANENT:
                activeSpell.getCard().activateEffect(this);
                break;
            case TEMPORARY:
                activeSpells.add(activeSpell);
                break;
        }

        this.activeSpells.add(activeSpell);
    }

    public void updateState() {
        this.maxHp = this.getCard().getBaseHp() + (this.level - 1) * this.getCard().getHpUp();
        this.atk = this.getCard().getBaseAtk() + (this.level - 1) * this.getCard().getAtkUp();

        for (ActiveSpell activeSpell : activeSpells) {
            activeSpell.activateEffect(this);
            if (activeSpell.getActiveDuration() <= 0) {
                activeSpells.remove(activeSpell);
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

        return this.getName() + " " + this.getHp() + "/" + this.getMaxHp() + " " + this.getAtk() + " " + this.getDescription();
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
            this.level++;
            this.exp = 0;
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
}