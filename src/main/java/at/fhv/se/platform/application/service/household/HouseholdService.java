package at.fhv.se.platform.application.service.household;

import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.adapter.dto.HouseholdUserMappingDTO;
import at.fhv.se.platform.adapter.dto.UserDTO;
import at.fhv.se.platform.application.service.user.UserService;
import at.fhv.se.platform.domain.model.Household;
import at.fhv.se.platform.domain.model.HouseholdType;
import at.fhv.se.platform.domain.model.User;
import at.fhv.se.platform.domain.port.inbound.household.AssignUserToHouseholdUseCase;
import at.fhv.se.platform.domain.port.inbound.household.CreateHouseholdUseCase;
import at.fhv.se.platform.domain.port.inbound.household.GetAllHouseholdsUseCase;
import at.fhv.se.platform.domain.port.inbound.household.GetHouseholdUseCase;
import at.fhv.se.platform.domain.port.outbound.persistence.HouseholdRepository;
import at.fhv.se.platform.domain.port.outbound.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

@Service
public class HouseholdService implements CreateHouseholdUseCase,
        GetAllHouseholdsUseCase,
        GetHouseholdUseCase,
        AssignUserToHouseholdUseCase {

    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createHousehold(HouseholdDTO householdDTO) {
        this.householdRepository.save(new Household(householdDTO.getStreet(),
                householdDTO.getStreetNo(), householdDTO.getDoorNo(), householdDTO.getCity(), householdDTO.getZip(),
                householdDTO.getCountry(), HouseholdType.valueOf(householdDTO.getType()), householdDTO.getSize(),
                householdDTO.getResidentsNo()));
        return householdDTO.getId(); //TODO Id
    }

    @Override
    public List<HouseholdDTO> getAllHouseholds() {
        return this.householdRepository.getAllHouseholds().stream()
                .map(household -> new HouseholdDTO(
                        household.getId().toString(),
                        household.getStreet(),
                        household.getStreetNo(),
                        household.getDoorNo(),
                        household.getCity(),
                        household.getZip(),
                        household.getCountry(),
                        household.getType().toString(),
                        household.getSize(),
                        household.getResidentsNo(),
                        household.getUserList().stream().map(HouseholdService::userToDTO).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public HouseholdDTO getHousehold(String id) {
        Household household = this.getHouseholdModel(id);
        return household != null ? new HouseholdDTO(household.getId().toString(), household.getStreet(),
                household.getStreetNo(), household.getDoorNo(), household.getCity(), household.getZip(),
                household.getCountry(), household.getType().toString(), household.getSize(), household.getResidentsNo(),
                household.getUserList().stream().map(HouseholdService::userToDTO).collect(Collectors.toList()))
                : null;
    }


    @Override
    public String assignUserToHousehold(HouseholdUserMappingDTO householdUserMappingDTO) {
        Household household = this.getHouseholdModel(householdUserMappingDTO.getHouseholdId());
        User user = this.getUserModel(householdUserMappingDTO.getUserId());
        if (household != null && user != null) {
            this.householdRepository.assignUser(user, household);
            return user.getId().toString() + "_" + household.getId().toString();
        }
        return null;
    }

    private Household getHouseholdModel(String id) {
        return this.householdRepository.getHousehold(id);
    }

    private User getUserModel(String id) {
        return this.userRepository.getUser(id);
    }

    private static UserDTO userToDTO(User user){
        return new UserDTO(user.getId().toString(), user.getFirstName(), user.getLastName());
    }
}
