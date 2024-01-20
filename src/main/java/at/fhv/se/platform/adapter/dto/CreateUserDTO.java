package at.fhv.se.platform.adapter.dto;

/**
 * @author Justin Ströhle
 * 18.01.2024
 */

public class CreateUserDTO {
    String firstname;
    String lastname;

    public CreateUserDTO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
