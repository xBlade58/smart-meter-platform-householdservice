package at.fhv.se.platform.adapter.postgresdb.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

@Entity
@Table(name = "meter_user")
public class UserDBEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public UserDBEntity() {
    }

    public UserDBEntity(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
