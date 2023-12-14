package at.fhv.se.platform.adapter.dto;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

public class HouseholdDTO {
    private String id;
    private String street;
    private String streetNo;
    private String doorNo;
    private String city;
    private String zip;
    private String country;
    private String type;
    private double size;
    private int residentsNo;

    public HouseholdDTO(String id, String street, String streetNo, String doorNo, String city, String zip,
                        String country, String type, double size, int residentsNo) {
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

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getResidentsNo() {
        return residentsNo;
    }

    public void setResidentsNo(int residentsNo) {
        this.residentsNo = residentsNo;
    }
}
