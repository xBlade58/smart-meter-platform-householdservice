package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.mapper.HouseholdDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface PostgresJPAHousehold extends JpaRepository<HouseholdDBEntity, UUID> {
}
