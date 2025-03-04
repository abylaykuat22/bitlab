package com.example.g130trello.exception;

import jakarta.persistence.PersistenceException;

public class EntityNotFoundException extends PersistenceException {

    public EntityNotFoundException(String message) {
        super(message);
    }

}
