package at.fhv.se.platform.application.service.household;

import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.domain.port.inbound.household.CreateHouseholdUseCase;
import at.fhv.se.platform.domain.port.inbound.household.GetAllHouseholdsUseCase;
import at.fhv.se.platform.domain.port.inbound.household.GetHouseholdUseCase;
import at.fhv.se.platform.domain.port.outbound.persistence.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

@Service
public class HouseholdService implements CreateHouseholdUseCase, GetAllHouseholdsUseCase, GetHouseholdUseCase {

    @Autowired
    private HouseholdRepository householdRepository;

    @Override
    public String createHousehold(HouseholdDTO householdDTO) {
        return null;
    }

    @Override
    public List<HouseholdDTO> getAllHouseholds() {
        return null;
    }

    @Override
    public HouseholdDTO getHousehold(String id) {
        return null;
    }


}
