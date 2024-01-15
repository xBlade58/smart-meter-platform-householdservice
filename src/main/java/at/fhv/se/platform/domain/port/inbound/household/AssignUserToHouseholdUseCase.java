package at.fhv.se.platform.domain.port.inbound.household;

import at.fhv.se.platform.adapter.dto.HouseholdUserMappingDTO;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface AssignUserToHouseholdUseCase {
    String assignUserToHousehold(HouseholdUserMappingDTO householdUserMappingDTO);
}
