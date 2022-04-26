package com.aetherwars.exception;

public class EmptySlotException extends Exception {
    public EmptySlotException() {
        super("Slot is empty!");
    }
}
