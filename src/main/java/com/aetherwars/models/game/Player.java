package com.aetherwars.models.game;

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
        this.hp = 80;
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

    public void draw(int idx) throws Exception {
        hand.add(deck.remove(idx));
    }

    public void play(int hand_idx, int board_idx) {
        System.out.println("Hand Size: " + hand.getCards().size());
        if (hand.get(hand_idx).getCardData().getManaCost() <= mana) {
            try {
                int cost = hand.get(hand_idx).getCardData().getManaCost();
                hand.activate(hand_idx, board_idx);
                mana -= cost;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void attack(int from, int to) {
        Game game = Game.getInstance();
        if (to == -1) {
            System.out.println(game.getPlayerBoard().get(from).getName() + " attacked " + game.getEnemy().getName());
            game.getPlayerBoard().get(from).attack(game.getEnemy());
        } else {
            System.out.println(
                    game.getPlayerBoard().get(from).getName() + " attacked " + game.getEnemyBoard().get(to).getName());
            game.getPlayerBoard().get(from).attack(game.getEnemyBoard().get(to));
        }
    }

    public void attacked(ActiveCharacter attacker) {
        hp -= attacker.getAtk();
    }

    public String toString() {
        String res = name + ": " + hp + " hp, " + mana + " mana";
        res += "\n" + deck.toString();
        res += "\nHand:\n" + hand.toString();
        return res;
    }
}
