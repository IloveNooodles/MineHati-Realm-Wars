package com.aetherwars.exception;

public class BoardFullException extends Exception {
	String message;
	public BoardFullException() {
		this.message = "Board is full";
	}
	public String toString() {
		return this.message;
	}
	
}
