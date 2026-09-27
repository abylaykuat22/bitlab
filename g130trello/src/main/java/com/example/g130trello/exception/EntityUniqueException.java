package com.example.g130trello.exception;

import jakarta.persistence.PersistenceException;

public class EntityUniqueException extends PersistenceException {


    public EntityUniqueException(String message){
        super(message);
    }

}
