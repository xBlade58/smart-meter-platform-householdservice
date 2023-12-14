package at.fhv.se.platform.application.service.household;

import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.domain.model.Household;
import at.fhv.se.platform.domain.model.HouseholdType;
import at.fhv.se.platform.domain.port.inbound.household.CreateHouseholdUseCase;
import at.fhv.se.platform.domain.port.inbound.household.GetAllHouseholdsUseCase;
import at.fhv.se.platform.domain.port.inbound.household.GetHouseholdUseCase;
import at.fhv.se.platform.domain.port.outbound.persistence.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        this.householdRepository.save(new Household(householdDTO.getId(), householdDTO.getStreet(),
                householdDTO.getStreetNo(), householdDTO.getDoorNo(), householdDTO.getCity(), householdDTO.getZip(),
                householdDTO.getCountry(), HouseholdType.valueOf(householdDTO.getType()), householdDTO.getSize(),
                householdDTO.getResidentsNo()));
        return householdDTO.getId(); //TODO Id
    }

    @Override
    public List<HouseholdDTO> getAllHouseholds() {
        return this.householdRepository.getAllHouseholds().stream()
                .map(household -> new HouseholdDTO(
                        household.getId(),
                        household.getStreet(),
                        household.getStreetNo(),
                        household.getDoorNo(),
                        household.getCity(),
                        household.getZip(),
                        household.getCountry(),
                        household.getType().toString(),
                        household.getSize(),
                        household.getResidentsNo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public HouseholdDTO getHousehold(String id) {
        Household household = this.householdRepository.getHousehold(id);
        return new HouseholdDTO(household.getId(), household.getStreet(), household.getStreetNo(),
                household.getDoorNo(), household.getCity(), household.getZip(), household.getCountry(),
                household.getType().toString(), household.getSize(), household.getResidentsNo());
    }
}
