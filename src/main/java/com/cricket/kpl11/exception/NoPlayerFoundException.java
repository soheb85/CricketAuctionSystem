package com.cricket.kpl11.exception;

public class NoPlayerFoundException extends RuntimeException{
    public NoPlayerFoundException(String message){
        super(message);
    }
}
