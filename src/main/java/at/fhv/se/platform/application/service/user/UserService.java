package at.fhv.se.platform.application.service.user;

import at.fhv.se.platform.adapter.dto.HouseholdDTO;
import at.fhv.se.platform.adapter.dto.UserDTO;
import at.fhv.se.platform.domain.model.User;
import at.fhv.se.platform.domain.port.inbound.user.CreateUserUseCase;
import at.fhv.se.platform.domain.port.inbound.user.GetAllUsersUseCase;
import at.fhv.se.platform.domain.port.inbound.user.GetUserUseCase;
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
public class UserService implements CreateUserUseCase, GetAllUsersUseCase, GetUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserDTO userDTO) {
        this.userRepository.save(new User(userDTO.getId(), userDTO.getFirstname(), userDTO.getLastname()));
        return userDTO.getId(); //TODO ID
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepository.getAllUsers().stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(String id) {
        User user = this.userRepository.getUser(id);
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName());
    }
}
