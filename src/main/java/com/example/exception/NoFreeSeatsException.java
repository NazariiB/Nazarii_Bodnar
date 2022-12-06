package com.example.exception;

public class NoFreeSeatsException extends RuntimeException{
    public  NoFreeSeatsException() {
        super("No free seats in train");
    }
}
