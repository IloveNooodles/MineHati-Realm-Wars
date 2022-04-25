package com.aetherwars.models.cardcontainer;


import com.aetherwars.models.card.Card;
import com.aetherwars.exception.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck extends CardContainer<Card> {
    public Deck() {
        super();
        initializeDeck();
    }

    public void initializeDeck() {
        Random ran = new Random();
        int x = ran.nextInt(21);
        int y = ran.nextInt(21 - x);
        int totalCharacter = 20 + x;
        int totalSpell = 20 + y;
        while (totalCharacter > 0) {
            //TODO : bikin kartu karakter terus add
        }
        while (totalSpell > 0) {
            //TODO : bikin kartu spell terus add
        }
        this.shuffle();
    }
    
    public Card remove(int idx) throws EmptyDeckException {
        if (cards.size() == 0) {
            throw new EmptyDeckException();
        }
        Card temp = cards.get(idx);
        cards.remove(idx);
        return temp;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toString() {
        return "Deck: " + cards.size();
    }
}
