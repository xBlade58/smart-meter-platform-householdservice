package at.fhv.se.platform.domain.model;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private List<Household> householdList;

    private User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.householdList = new LinkedList<>();
    }

    public User(UUID id, String firstName, String lastName, List<Household> householdList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.householdList = householdList;
    }

    public User(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.householdList = new LinkedList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Household> getHouseholdList() {
        return householdList;
    }
}
