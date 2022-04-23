package com.aetherwars.models.cardcontainer;

import java.util.*;

public abstract class CardContainer<T> {
    protected ArrayList<T> cards;

    public CardContainer() {
        cards = new ArrayList<T>();
    }

    public T get(int idx) {
        return cards.get(idx);
    }

    public boolean isPosValid(int idx){
        return this.cards.get(idx) != null;
    }

    public abstract T remove(int idx) throws Exception;

    public abstract void add(T card) throws Exception;
}