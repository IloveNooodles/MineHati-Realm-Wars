package com.aetherwars.exception;

public class InvalidNumberException extends Exception {
    public InvalidNumberException() {
        super("Must be a positive number");
    }
}
