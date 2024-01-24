package at.fhv.se.platform.application.port.inbound.household;

import at.fhv.se.platform.adapter.dto.HouseholdDTO;

import java.util.List;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface GetAllHouseholdsUseCase {
    List<HouseholdDTO> getAllHouseholds();
}
