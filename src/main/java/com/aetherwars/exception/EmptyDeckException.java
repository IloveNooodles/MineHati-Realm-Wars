package com.aetherwars.exception;

public class EmptyDeckException extends Exception {
    public EmptyDeckException() {
        super("Deck is empty!");
    }
}
