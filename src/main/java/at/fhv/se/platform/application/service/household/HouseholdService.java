package at.fhv.se.platform.application.service.household;


import at.fhv.se.platform.adapter.dto.CreateHouseholdDTO;
import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.adapter.dto.HouseholdUserMappingDTO;
import at.fhv.se.platform.adapter.dto.UserDTO;
import at.fhv.se.platform.application.exceptions.HouseholdNotFoundException;
import at.fhv.se.platform.application.exceptions.UserNotFoundException;
import at.fhv.se.platform.application.port.inbound.household.*;
import at.fhv.se.platform.domain.events.MeterAssignedEvent;
import at.fhv.se.platform.domain.model.Household;
import at.fhv.se.platform.domain.model.HouseholdType;
import at.fhv.se.platform.domain.model.User;
import at.fhv.se.platform.application.port.outbound.EventPublisher;
import at.fhv.se.platform.application.port.outbound.persistence.HouseholdRepository;
import at.fhv.se.platform.application.port.outbound.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

@Service
public class HouseholdService implements CreateHouseholdUseCase,
        GetAllHouseholdsUseCase,
        GetHouseholdUseCase,
        AssignUserToHouseholdUseCase,
        AssignMeterToHouseholdUseCase,
        GetHouseholdFromUserUseCase {

    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public String createHousehold(CreateHouseholdDTO householdDTO) {
        return this.householdRepository.save(new Household(householdDTO.getStreet(),
                householdDTO.getStreetNo(), householdDTO.getDoorNo(), householdDTO.getCity(), householdDTO.getZip(),
                householdDTO.getCountry(), HouseholdType.valueOf(householdDTO.getType()), householdDTO.getSize(),
                householdDTO.getResidentsNo()));

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
    public String assignUserToHousehold(HouseholdUserMappingDTO householdUserMappingDTO) throws HouseholdNotFoundException, UserNotFoundException {
        Household household = this.getHouseholdModel(householdUserMappingDTO.getHouseholdId());
        User user = this.getUserModel(householdUserMappingDTO.getUserId());
        if (household != null && user != null) {
            this.householdRepository.assignUser(user, household);
            return user.getId().toString() + "_" + household.getId().toString();
        } else {
            if (household == null) {
                throw new HouseholdNotFoundException(householdUserMappingDTO.getHouseholdId());
            } else {
                throw new UserNotFoundException(householdUserMappingDTO.getUserId());
            }
        }
    }

    @Override
    public List<HouseholdDTO> getHouseholdFromUser(UUID userId) throws UserNotFoundException {
        User user = this.getUserModel(userId.toString());
        if (user != null) {
            return this.householdRepository.getHouseholdsFromUser(user).stream()
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
        } else {
            throw new UserNotFoundException(userId.toString());
        }
    }

    @Override
    public void assign(String householdId, String meterId) throws HouseholdNotFoundException {
        Household h = householdRepository.getHousehold(householdId);
        if (h != null) {
            h.assingMeter(meterId);
            householdRepository.assignMeter(h.getId(), meterId);
            eventPublisher.publishHosueholdEvent(new MeterAssignedEvent(h.getId().toString(), LocalDateTime.now(), meterId));
        } else {
            throw new HouseholdNotFoundException(householdId);
        }
    }

    private Household getHouseholdModel(String id) {
        return this.householdRepository.getHousehold(id);
    }

    private User getUserModel(String id) {
        return this.userRepository.getUser(id);
    }

    private static UserDTO userToDTO(User user) {
        return new UserDTO(user.getId().toString(), user.getFirstName(), user.getLastName());
    }


}
