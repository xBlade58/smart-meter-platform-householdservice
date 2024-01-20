package at.fhv.se.platform.domain.port.inbound.user;

import at.fhv.se.platform.adapter.dto.CreateUserDTO;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface CreateUserUseCase {
    String createUser(CreateUserDTO userDTO);
}
