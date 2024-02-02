package com.example.sockwarehouse.exceptions;

public class SocksNotFoundException extends RuntimeException{
    public SocksNotFoundException(String message) {
        super(message);
    }
}
