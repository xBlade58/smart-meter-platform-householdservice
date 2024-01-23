package at.fhv.se.platform.application.port.inbound.household;

import at.fhv.se.platform.adapter.dto.CreateHouseholdDTO;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface CreateHouseholdUseCase {
    String createHousehold(CreateHouseholdDTO householdDTO);
}
