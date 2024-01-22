package at.fhv.se.platform.adapter.postgresdb;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.platform.adapter.postgresdb.model.HouseholdUserMappingDBEntity;

/**
 * @author Justin Ströhle
 * 11.01.2024
 */

public interface PostgresJPAHouseholdUser extends JpaRepository<HouseholdUserMappingDBEntity, HouseholdUserMappingDBEntity.HouseholdUserKey> {
}
