package at.fhv.se.platform.adapter.dto;

/**
 * @author Justin Ströhle
 * 18.01.2024
 */

public class CreateHouseholdDTO {
    private String street;
    private String streetNo;
    private String doorNo;
    private String city;
    private String zip;
    private String country;
    private String type;
    private double size;
    private int residentsNo;

    public CreateHouseholdDTO(String street, String streetNo, String doorNo, String city, String zip, String country,
                              String type, double size, int residentsNo) {
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

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public int getResidentsNo() {
        return residentsNo;
    }
}
