package com.aetherwars.exception;

public class BoardAlreadyFilledException extends Exception {
    String message;
    public BoardAlreadyFilledException() {
        this.message = "Sudah ada kartu di sini";
    }

    public String toString() {
        return this.message;
    }
}
