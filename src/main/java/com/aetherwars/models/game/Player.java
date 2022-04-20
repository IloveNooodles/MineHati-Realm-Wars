package com.aetherwars.models.game;

import com.aetherwars.interfaces.Attackable;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.cardcontainer.Deck;
import com.aetherwars.models.cardcontainer.Hand;

public class Player implements Attackable {
    private String name;
    private int hp;
    private int mana;
    private Deck deck;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hp = 30;
        this.mana = 1;
        this.deck = new Deck();
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

    public void draw() {
        hand.add(deck.remove(0));
    }

    public void play(int hand_idx, int board_idx) {
        hand.activate(hand_idx, board_idx);
    }

    public void attacked(ActiveCharacter attacker) {
        hp -= attacker.getAtk();
    }

}

