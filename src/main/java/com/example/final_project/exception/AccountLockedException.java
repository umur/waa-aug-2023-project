package com.example.final_project.exception;

public class AccountLockedException extends RuntimeException{
    public AccountLockedException(String s) {
        super(s);
    }
}
