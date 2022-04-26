package com.aetherwars.exception;

public class BoardAlreadyFilledException extends Exception {
    public BoardAlreadyFilledException() {
        super("Cannot replace existing card");
    }
}
