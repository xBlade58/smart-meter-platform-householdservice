package at.fhv.se.platform.domain.model;

import java.util.List;
import java.util.UUID;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

public class Household {
    private UUID id;
    private String street;
    private String streetNo;
    private String doorNo;
    private String city;
    private String zip;
    private String country;
    private HouseholdType type;
    private double size;
    private int residentsNo;
    private String meterId;
    private List<User> userList;

    public Household() {
    }

    public Household(String street, String streetNo, String doorNo, String city, String zip, String country,
                     HouseholdType type, double size, int residentsNo) {
        this.street = street;
        this.streetNo = streetNo;
        this.doorNo = doorNo;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.type = type;
        this.size = size;
        this.residentsNo = residentsNo;
    }

    public Household(UUID id, String street, String streetNo, String doorNo, String city, String zip, String country,
                     HouseholdType type, double size, int residentsNo) {
        this.id = id;
        this.street = street;
        this.streetNo = streetNo;
        this.doorNo = doorNo;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.type = type;
        this.size = size;
        this.residentsNo = residentsNo;
    }

    public Household(UUID id, String street, String streetNo, String doorNo, String city, String zip, String country,
                     HouseholdType type, double size, int residentsNo, List<User> userList) {
        this.id = id;
        this.street = street;
        this.streetNo = streetNo;
        this.doorNo = doorNo;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.type = type;
        this.size = size;
        this.residentsNo = residentsNo;
        this.userList = userList;
    }

    public void assingMeter(String meterId) {
        this.meterId = meterId;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public HouseholdType getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public int getResidentsNo() {
        return residentsNo;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getMeterId() {
        return meterId;
    }
}
