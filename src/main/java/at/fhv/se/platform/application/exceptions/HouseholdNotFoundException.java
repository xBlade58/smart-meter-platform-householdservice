package at.fhv.se.platform.application.exceptions;

/**
 * @author Justin Ströhle
 * 23.01.2024
 */

public class HouseholdNotFoundException extends Exception {
    public HouseholdNotFoundException(String householdId) {
        super("No household found with id = " + householdId);
    }
}
