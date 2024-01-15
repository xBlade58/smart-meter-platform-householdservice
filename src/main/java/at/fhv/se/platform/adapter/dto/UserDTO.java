package at.fhv.se.platform.adapter.dto;


import java.util.LinkedList;
import java.util.List;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

public class UserDTO {
    String id;
    String firstname;
    String lastname;
    List<HouseholdDTO> households;

    public UserDTO(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.households = new LinkedList<>();
    }

    public UserDTO(String id, String firstname, String lastname, List<HouseholdDTO> households) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.households = households;
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
