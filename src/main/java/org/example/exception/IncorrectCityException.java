package org.example.exception;

public class IncorrectCityException extends RuntimeException {
    public IncorrectCityException() {
        super("City can not be found");
    }
}
