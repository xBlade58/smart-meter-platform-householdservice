package at.fhv.se.platform.adapter.postgresdb;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import at.fhv.se.platform.adapter.postgresdb.model.HouseholdDBEntity;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface PostgresJPAHousehold extends JpaRepository<HouseholdDBEntity, UUID> {
    @Query("SELECT h FROM HouseholdDBEntity h INNER JOIN FETCH h.users u WHERE u.id.userId = :userId")
    List<HouseholdDBEntity> findByUserID(@Param("userId") UUID userId);

    @Query("UPDATE HouseholdDBEntity SET meterId = :meterId WHERE id =:householdId")
    void assignMeter(@Param("householdId") UUID householdId, @Param("meterId") String meterId);

}
