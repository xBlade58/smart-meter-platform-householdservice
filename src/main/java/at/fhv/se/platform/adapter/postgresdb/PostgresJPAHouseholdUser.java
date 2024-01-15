package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.mapper.HouseholdUserMappingDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Justin Ströhle
 * 11.01.2024
 */

public interface PostgresJPAHouseholdUser extends JpaRepository<HouseholdUserMappingDBEntity, HouseholdUserMappingDBEntity.HouseholdUserKey> {
}
