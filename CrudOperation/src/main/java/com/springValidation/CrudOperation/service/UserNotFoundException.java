package com.springValidation.CrudOperation.service;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String error){
        super(error);
    }

}