package at.fhv.se.platform.domain.port.outbound.persistence;

import at.fhv.se.platform.domain.model.Household;
import at.fhv.se.platform.domain.model.User;

import java.util.List;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

public interface HouseholdRepository {
    String save(Household household);

    List<Household> getAllHouseholds();

    Household getHousehold(String id);

    void assignUser(User user, Household household);
}
