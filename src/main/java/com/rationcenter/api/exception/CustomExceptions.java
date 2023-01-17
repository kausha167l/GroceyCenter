package com.rationcenter.api.exception;

public class CustomExceptions extends IllegalArgumentException{
    public CustomExceptions(String msg) {
        super(msg);
    }
}
