package com.aetherwars.models.game;

import com.aetherwars.interfaces.Attackable;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.cardcontainer.Deck;
import com.aetherwars.models.cardcontainer.Hand;
import com.aetherwars.models.carddata.spell.LVL;

public class Player implements Attackable {
    private final String name;
    private final Deck deck;
    private final Hand hand;
    private int hp;
    private int mana;

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
        if (hand.getCards().size() == 5) {
            /* Hapus hand paling kiri */
            hand.remove(0);
        }
        hand.add(deck.remove(idx));
    }

    public void play(int hand_idx, int board_idx) {
        System.out.println("Hand Size: " + hand.getCards().size());
        int cost = hand.get(hand_idx).getCardData().getManaCost();
        Game game = Game.getInstance();
        if (hand.get(hand_idx).getCardData() instanceof LVL) {
            cost = (int) Math.ceil((double) game.getPlayerBoard().get(board_idx).getLevel() / 2);
        }
        if (cost <= mana) {
            try {
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
        res += "\n" + deck;
        res += "\nHand:\n" + hand;
        return res;
    }
}
