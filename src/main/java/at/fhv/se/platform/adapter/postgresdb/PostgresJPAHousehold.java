package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.mapper.HouseholdDBEntity;
import at.fhv.se.platform.adapter.postgresdb.mapper.UserDBEntity;
import at.fhv.se.platform.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface PostgresJPAHousehold extends JpaRepository<HouseholdDBEntity, UUID> {
    @Query("SELECT h FROM HouseholdDBEntity h INNER JOIN FETCH h.users u WHERE u.id.userId = :userId")
    List<HouseholdDBEntity> findByUserID(@Param("userId") UUID userId);
}
