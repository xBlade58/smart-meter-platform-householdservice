package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.mapper.UserDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

public interface PostgresJPAUser extends JpaRepository<UserDBEntity, UUID> {
}
