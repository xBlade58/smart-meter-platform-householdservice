package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.mapper.HouseholdDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface PostgresJPAHousehold  extends JpaRepository<HouseholdDBEntity, String> {
}
