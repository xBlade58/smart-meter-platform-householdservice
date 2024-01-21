package at.fhv.se.platform.adapter.rest;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.fhv.se.platform.adapter.dto.AssignMeterDTO;
import at.fhv.se.platform.adapter.dto.CreateHouseholdDTO;
import at.fhv.se.platform.adapter.dto.CreateUserDTO;
import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.adapter.dto.HouseholdUserMappingDTO;
import at.fhv.se.platform.adapter.dto.UserDTO;
import at.fhv.se.platform.application.service.household.HouseholdService;
import at.fhv.se.platform.application.service.user.UserService;
import at.fhv.se.platform.domain.port.inbound.household.AssignMeterToHouseholdUseCase;


/**
 * @author Justin Ströhle
 * 22.11.2023
 */

@RestController
@RequestMapping(path = "/dev/v1/")
public class DevController {

    @Autowired
    private UserService userService;

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private AssignMeterToHouseholdUseCase assignMeterToHouseholdUseCase;

    @GetMapping(value = "/getUsers")
    public ResponseEntity getAllUsers(){
        List<UserDTO> users = this.userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/getHouseholds")
    public ResponseEntity getAllHouseholds(){
        List<HouseholdDTO> households = this.householdService.getAllHouseholds();
        return ResponseEntity.ok().body(households);
    }


    @GetMapping(value = "/getHouseholdsFromUser/{userId}")
    public ResponseEntity getHouseholdsFromUser(@PathVariable(value = "userId") UUID userId) {
        List<HouseholdDTO> households = this.householdService.getHouseholdFromUser(userId);
        return ResponseEntity.ok().body(households);
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody CreateUserDTO userDTO) {
        this.userService.createUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/createHousehold", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createHousehold(@RequestBody CreateHouseholdDTO householdDTO) {

        this.householdService.createHousehold(householdDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/createHouseholdUserMapping", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createHouseholdUserMapping(@RequestBody HouseholdUserMappingDTO householdUserMappingDTO) {
        this.householdService.assignUserToHousehold(householdUserMappingDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{householdId}/assignMeter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity assignMeterToHousehold(@PathVariable String householdId, @RequestBody AssignMeterDTO assignMeterDTO) {
        assignMeterToHouseholdUseCase.assign(householdId, assignMeterDTO.getMeterId());
        return ResponseEntity.ok().body("Meter was assigned successfully.");
    }

}
