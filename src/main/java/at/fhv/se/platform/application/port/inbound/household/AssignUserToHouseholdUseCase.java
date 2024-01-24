package at.fhv.se.platform.application.port.inbound.household;

import at.fhv.se.platform.adapter.dto.HouseholdUserMappingDTO;
import at.fhv.se.platform.application.exceptions.HouseholdNotFoundException;
import at.fhv.se.platform.application.exceptions.UserNotFoundException;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface AssignUserToHouseholdUseCase {
    String assignUserToHousehold(HouseholdUserMappingDTO householdUserMappingDTO) throws HouseholdNotFoundException, UserNotFoundException;
}
