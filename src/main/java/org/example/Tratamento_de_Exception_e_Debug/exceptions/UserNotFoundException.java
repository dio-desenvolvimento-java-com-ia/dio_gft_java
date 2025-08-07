package org.example.Tratamento_de_Exception_e_Debug.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final String message){
        super(message);
    }
}
