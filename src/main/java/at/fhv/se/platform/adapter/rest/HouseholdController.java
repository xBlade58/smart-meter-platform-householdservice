package at.fhv.se.platform.adapter.rest;


import at.fhv.se.platform.adapter.dto.*;
import at.fhv.se.platform.application.exceptions.HouseholdNotFoundException;
import at.fhv.se.platform.application.exceptions.UserNotFoundException;
import at.fhv.se.platform.application.service.household.HouseholdService;
import at.fhv.se.platform.application.service.user.UserService;
import at.fhv.se.platform.application.port.inbound.household.AssignMeterToHouseholdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


/**
 * @author Justin Ströhle
 * 22.11.2023
 */

@RestController
@RequestMapping(path = "/api/v1/households/")
public class HouseholdController {

    @Autowired
    private UserService userService;

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private AssignMeterToHouseholdUseCase assignMeterToHouseholdUseCase;

    @GetMapping(value = "/getUsers")
    public ResponseEntity getAllUsers() {
        List<UserDTO> users = this.userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/getHouseholds")
    public ResponseEntity getAllHouseholds() {
        List<HouseholdDTO> households = this.householdService.getAllHouseholds();
        return ResponseEntity.ok().body(households);
    }


    @GetMapping(value = "/getHouseholdsFromUser/{userId}")
    public ResponseEntity getHouseholdsFromUser(@PathVariable(value = "userId") UUID userId) {
        try {
            List<HouseholdDTO> households = this.householdService.getHouseholdFromUser(userId);
            return ResponseEntity.ok().body(households);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody CreateUserDTO userDTO) {
        String id = this.userService.createUser(userDTO);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/createHousehold", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createHousehold(@RequestBody CreateHouseholdDTO householdDTO) {
        String id = this.householdService.createHousehold(householdDTO);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/createHouseholdUserMapping", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createHouseholdUserMapping(@RequestBody HouseholdUserMappingDTO householdUserMappingDTO) {
        try {
            String id = this.householdService.assignUserToHousehold(householdUserMappingDTO);
            return ResponseEntity.ok().body(id);
        } catch (HouseholdNotFoundException | UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping(value = "/{householdId}/assignMeter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity assignMeterToHousehold(@PathVariable String householdId, @RequestBody AssignMeterDTO assignMeterDTO) {
        try {
            assignMeterToHouseholdUseCase.assign(householdId, assignMeterDTO.getMeterId());
            return ResponseEntity.ok().body("Meter was assigned successfully.");
        } catch (HouseholdNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
