package com.rationcenter.api.exception;

public class AuthenticationFailedException extends IllegalArgumentException {
    public AuthenticationFailedException(String msg){
        super(msg);
    }
}
