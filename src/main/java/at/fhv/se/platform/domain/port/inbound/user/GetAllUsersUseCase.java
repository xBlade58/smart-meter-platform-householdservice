package at.fhv.se.platform.domain.port.inbound.user;

import at.fhv.se.platform.adapter.dto.UserDTO;

import java.util.List;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface GetAllUsersUseCase {
    List<UserDTO> getAllUsers();
}
