package at.fhv.se.platform.application.service.user;

import at.fhv.se.platform.adapter.dto.UserDTO;
import at.fhv.se.platform.domain.port.inbound.user.CreateUserUseCase;
import at.fhv.se.platform.domain.port.inbound.user.GetAllUsersUseCase;
import at.fhv.se.platform.domain.port.inbound.user.GetUserUseCase;
import at.fhv.se.platform.domain.port.outbound.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUser(String id) {
        return null;
    }
}
