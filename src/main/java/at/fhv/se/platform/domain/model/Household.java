package at.fhv.se.platform.domain.model;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

public class Household {
    private String id;
    private String street;
    private String streetNo;
    private String doorNo;
    private String city;
    private String zip;
    private String country;
    private HouseholdType type;
    private double size;
    private int residentsNo;

    public Household() {
    }

    public Household(String id, String street, String streetNo, String doorNo, String city, String zip, String country,
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}