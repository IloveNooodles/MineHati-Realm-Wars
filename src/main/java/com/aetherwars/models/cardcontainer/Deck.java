package com.aetherwars.models.cardcontainer;

import com.aetherwars.models.card.Card;
import com.aetherwars.exception.*;

import java.util.Collections;
import java.util.List;

public class Deck extends CardContainer<Card> {
    public Deck() {
        super();
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
