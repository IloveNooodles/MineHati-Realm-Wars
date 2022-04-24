package com.aetherwars.models.game;

import com.aetherwars.exception.EmptyDeckException;
import com.aetherwars.interfaces.Attackable;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.cardcontainer.Deck;
import com.aetherwars.models.cardcontainer.Hand;

public class Player implements Attackable {
    private final String name;
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

    public void draw() throws EmptyDeckException {
        hand.add(deck.remove(0));
    }

    public void play(int hand_idx, int board_idx) throws Exception {
        System.out.println("Hand Size: " + hand.getCards().size());
        if (hand.get(hand_idx).getCardData().getManaCost() <= mana) {
            mana -= hand.get(hand_idx).getCardData().getManaCost();

            hand.activate(hand_idx, board_idx);
        }

    }

    public void attack(int from, int to) {
        Game game = Game.getInstance();
        if (to == -1) {
            game.getPlayerBoard().get(from).attack(game.getEnemy());
        } else {
            game.getPlayerBoard().get(from).attack(game.getPlayerBoard().get(to));
        }
    }

    public void attacked(ActiveCharacter attacker) {
        hp -= attacker.getAtk();
    }

    public String toString() {
        String res = name + ": " + hp + " hp, " + mana + " mana";
        res += "\n" + deck.toString();
        res += "\n" + hand.toString();
        return res;
    }
}

