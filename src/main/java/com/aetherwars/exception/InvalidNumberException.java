package com.aetherwars.exception;

public class InvalidNumberException {
    private final String message;

    public InvalidNumberException() {
        this.message = "Number must be positive integer!";
    }

    public String toString() {
        return this.message;
    }
}
