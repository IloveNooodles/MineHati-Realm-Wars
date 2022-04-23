package com.aetherwars.models.cardcontainer;


import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.CardData;
import com.aetherwars.exception.*;

import java.util.Collections;

public class Deck extends CardContainer<Card> {
    public Deck() {
        super();
    }

    public Card remove(int idx) throws Exception {
        if (cards.size() == 0) {
            throw new EmptyDeckException();
        }
        Card temp = cards.get(idx);
        cards.remove(idx);
        return temp;
    }

    public void add(Card card){
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
