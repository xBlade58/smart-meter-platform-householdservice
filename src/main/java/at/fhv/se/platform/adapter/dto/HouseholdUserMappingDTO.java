package at.fhv.se.platform.adapter.dto;

/**
 * @author Justin Ströhle
 * 11.01.2024
 */

public class HouseholdUserMappingDTO {
    private String userId;
    private String householdId;

    public HouseholdUserMappingDTO(String userId, String householdId) {
        this.userId = userId;
        this.householdId = householdId;
    }

    public String getUserId() {
        return userId;
    }

    public String getHouseholdId() {
        return householdId;
    }
}
