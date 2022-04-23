package com.aetherwars.exception;

public class EmptySlotException extends Exception{
        String message;       
        public EmptySlotException() {
            this.message = "Tidak ada kartu di sini";
        }
        
        public String toString() {
            return this.message;
        }
}
