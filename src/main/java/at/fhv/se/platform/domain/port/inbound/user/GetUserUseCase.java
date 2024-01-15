package at.fhv.se.platform.domain.port.inbound.user;

import at.fhv.se.platform.adapter.dto.UserDTO;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface GetUserUseCase {
    UserDTO getUser(String id);
}
