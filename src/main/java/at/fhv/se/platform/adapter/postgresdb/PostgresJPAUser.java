package at.fhv.se.platform.adapter.postgresdb;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.platform.adapter.postgresdb.model.UserDBEntity;

import java.util.UUID;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

public interface PostgresJPAUser extends JpaRepository<UserDBEntity, UUID> {
}
