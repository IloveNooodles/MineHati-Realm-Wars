package com.aetherwars.exception;

public class EmptyHandException extends Exception {
    public EmptyHandException() {
        super("Hand is empty!");
    }
}
