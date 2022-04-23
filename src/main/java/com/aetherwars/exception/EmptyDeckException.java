package com.aetherwars.exception;

public class EmptyDeckException extends Exception {
    String message;       
    public EmptyDeckException() {
        this.message = "Tidak ada kartu pada deck";
    }
    
    public String toString() {
        return this.message;
    }
}
