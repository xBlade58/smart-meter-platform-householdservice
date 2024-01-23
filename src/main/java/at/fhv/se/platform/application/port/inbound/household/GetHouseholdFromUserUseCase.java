package at.fhv.se.platform.application.port.inbound.household;

import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.application.exceptions.UserNotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * @author Justin Ströhle
 * 18.01.2024
 */

public interface GetHouseholdFromUserUseCase {
    List<HouseholdDTO> getHouseholdFromUser(UUID userId) throws UserNotFoundException;
}
