package at.fhv.se.platform.adapter.dto;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

public class UserDTO {
    String id;
    String firstname;
    String lastname;

    public UserDTO(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
