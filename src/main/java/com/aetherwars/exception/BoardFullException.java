package com.aetherwars.exception;

public class BoardFullException extends Exception {
    public BoardFullException() {
        super("Board is full");
    }
}
