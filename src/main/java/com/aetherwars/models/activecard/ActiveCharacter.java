package com.aetherwars.models.activecard;

import com.aetherwars.interfaces.Attackable;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.PTN;
import com.aetherwars.models.carddata.spell.SWAP;

import java.util.ArrayList;

public class ActiveCharacter extends ActiveCard implements Attackable {
    private final ArrayList<ActiveSpell> activeSpells;
    private int exp;
    private int level;
    private double atk;
    private double hp;
    private double bonusAtk;
    private double bonusHp;
    private boolean isSwapped;
    private boolean hasAttacked;

    public ActiveCharacter() {
        super(new Character());
        this.exp = 0;
        this.level = 1;
        this.atk = 0;
        this.hp = 0;
        this.activeSpells = new ArrayList<ActiveSpell>();
        this.hasAttacked = false; // TODO : kalau udah ada ui, bisa diganti dengan disable button
        this.isSwapped = false;
        this.bonusAtk = 0;
        this.bonusHp = 0;
    }

    public ActiveCharacter(CardData card) {
        super(card);
        this.exp = 0;
        this.level = 1;
        this.atk = this.getCard().getBaseAtk();
        this.hp = this.getCard().getBaseHp();
        this.isSwapped = false;
        this.bonusHp = 0;
        this.bonusAtk = 0;
        this.activeSpells = new ArrayList<ActiveSpell>();
        this.hasAttacked = false;
    }

    public void addExp(int addedExp) {
        if (addedExp > 0) {
            if (this.level < 10) {
                this.exp += addedExp;
                int temp = this.exp;
                if (this.exp >= level * 2 - 1) {
                    this.levelUp();
                    if (this.level == 1) return;
                    int carry = temp - ((level - 1) * 2 - 1);
                    addExp(carry);
                }
            }
        }
    }

    public void attacked(ActiveCharacter attacker) {
        if (this.getCard().getType() == null) {
            System.out.println("Karakter sudah mati");
            return;
        }
        double attackingModifier = 1; // dari this ke musuh damagenya dikali berapa
        double attackedModifier = 1; // dari musuh ke this damagenya dikali berapa
        if (this.getCard().getType().compareTo(attacker.getCard().getType()) > 0) {
            attackingModifier = 2;
            attackedModifier = 0.5;
        } else if (this.getCard().getType().compareTo(attacker.getCard().getType()) < 0) {
            attackingModifier = 0.5;
            attackedModifier = 2;
        }

        double totalAttack = attacker.getAtk() * attackedModifier;

        System.out.println("attacked.hp sebelum = " + this.hp);
        this.hp -= totalAttack;
        System.out.println("attacked.hp sesudah = " + this.hp);

        if (this.hp <= 0) {
            this.hp = 0;
        }

        System.out.println("attacker.hp sebelum = " + attacker.hp);
        attacker.hp -= this.atk * attackingModifier;
        System.out.println("attacked.hp sesudah = " + attacker.hp);
        if (this.hp <= 0) {
            if (attacker.hp > 0) {
                /* exp ditambahkan bila attacker tidak mati */
                attacker.addExp(this.level);
            }
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
        return Math.max(atk + this.bonusAtk, 0);
    }

    public double getHp() {
        return this.hp + this.bonusHp;
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
                if (activeSpell.getCard() instanceof SWAP) {
                    if (this.isSwapped == true) {
                        for (ActiveSpell as : this.activeSpells) {
                            if (as.getCard() instanceof SWAP) {
                                ((SWAP) as.getCard()).setDuration(activeSpell.getActiveDuration());
                            }
                        }
                    } else {
                        activeSpell.getCard().activateEffect(this);
                        activeSpell.decrementActiveDuration();
                        activeSpells.add(activeSpell);
                    }
                    return;
                }

                activeSpell.getCard().activateEffect(this);

                if (this.getHp() <= 0) {
                    this.die();
                    return;
                }

                activeSpell.decrementActiveDuration();
                activeSpells.add(activeSpell);
                break;
        }
    }

    public void updateState() {
        int hpBonus = 0;
        this.hasAttacked = false;
        for (int i = this.activeSpells.size() - 1; i > -1; i--) {
            ActiveSpell as = this.activeSpells.get(i);
            as.decrementActiveDuration();
            if (as.getActiveDuration() <= 0) {
                if (as.getCard() instanceof SWAP) {
                    this.swap();
                }
                this.activeSpells.remove(i);
            } else {
                if (as.getCard() instanceof PTN) {
                    hpBonus += ((PTN) as.getCard()).getHpBonus();
                }
            }
        }

        if (this.bonusHp > hpBonus) {
            this.bonusHp = hpBonus;
        }

        if (this.getHp() <= 0) {
            this.die();
        }
    }

    private void die() {
        this.morph(new Character());
    }

    public String toString() {
        return this.getName() + " lvl" + this.getLevel() + " exp: (" + this.getExp() + "/" + (level * 2 - 1) + ") hp: ("
                + this.getHp() + "/"
                + this.getAtk() + " + this.getAtk()";
    }

    public void morph(CardData card) {
        this.card = card;
        this.exp = 0;
        this.level = 1;
        this.atk = this.getCard().getBaseAtk();
        this.hp = this.getCard().getBaseHp();
    }

    public void levelUp() {
        if (this.level < 10) {
            this.exp = 0;
            this.level++;
            if (isSwapped) {
                this.atk += this.getCard().getHpUp();
                this.hp = this.getCard().getBaseHp() + (this.level - 1) * this.getCard().getHpUp();
            } else {
                this.atk += this.getCard().getAtkUp();
                this.hp = this.getCard().getBaseHp() + (this.level - 1) * this.getCard().getHpUp();
            }
        }
    }

    public void levelDown() {
        if (this.level > 1) {
            this.level--;
            this.exp = 0;
            this.atk -= this.getCard().getAtkUp();
            this.hp = this.getCard().getBaseHp() + (this.level - 1) * this.getCard().getHpUp();
        }
    }

    public void swap() {
        this.isSwapped = !this.isSwapped;
        double hp = this.hp;
        this.hp = this.atk;
        this.atk = hp;
        double bonusHp = this.bonusHp;
        this.bonusHp = this.bonusAtk;
        this.bonusAtk = bonusHp;
    }

    public void increaseStats(double atk, double hp) {
        //dipake di potion, TIDAK langsung menngubah atk dan hp
        this.bonusAtk += atk;
        this.bonusHp += hp;
    }

    // ini bisa null pointer exception gara2 type nya ntar kosong
    public void attack(Attackable target) {
        if (this.getCard().getType() == null) {
            System.out.println("Karakter sudah mati");
            return;
        }
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