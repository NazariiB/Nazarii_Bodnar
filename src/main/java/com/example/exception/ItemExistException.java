package com.example.exception;

public class ItemExistException extends RuntimeException {
    public ItemExistException() {
        super("Item already exist");
    }
}
