package at.fhv.se.platform.application.exceptions;

/**
 * @author Justin Ströhle
 * 23.01.2024
 */

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userId) {
        super("No user found with id = " + userId);
    }
}
