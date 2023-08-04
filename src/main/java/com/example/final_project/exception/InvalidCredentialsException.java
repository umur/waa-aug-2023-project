package com.example.final_project.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String invalidUsernameOrPassword) {
        super(invalidUsernameOrPassword);
    }
}
