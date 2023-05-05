package com.ultimaschool.java.exceptions;

public class InvalidaEmailException extends Exception{

    private String errorMessage;

    public InvalidaEmailException (String email) {
        this.errorMessage = "O " + email + " digitado está inválido";
    }
}
