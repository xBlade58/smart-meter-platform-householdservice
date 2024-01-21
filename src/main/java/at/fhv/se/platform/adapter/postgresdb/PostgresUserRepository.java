package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.model.HouseholdDBEntity;
import at.fhv.se.platform.adapter.postgresdb.model.HouseholdUserMappingDBEntity;
import at.fhv.se.platform.adapter.postgresdb.model.UserDBEntity;
import at.fhv.se.platform.domain.model.Household;
import at.fhv.se.platform.domain.model.HouseholdType;
import at.fhv.se.platform.domain.port.outbound.persistence.UserRepository;
import at.fhv.se.platform.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Justin Ströhle
 * 07.12.2023
 */

@Repository
public class PostgresUserRepository implements UserRepository {

    @Autowired
    private PostgresJPAUser postgresJPAUser;

    @Override
    public String save(User user) {
        return this.postgresJPAUser.save(mapModelToDBEntity(user)).getId().toString();
    }

    @Override
    public List<User> getAllUsers() {
        return this.postgresJPAUser.findAll().stream()
                .map(PostgresUserRepository::mapDBEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public User getUser(String id) {
        Optional<UserDBEntity> userDBEntityOptional = this.postgresJPAUser.findById(UUID.fromString(id));
        return userDBEntityOptional.map(PostgresUserRepository::mapDBEntityToModel).orElse(null);
    }

    private static UserDBEntity mapModelToDBEntity(User model) {
        return new UserDBEntity(model.getFirstName(), model.getLastName());
    }

    private static User mapDBEntityToModel(UserDBEntity dbEntity) {
        return new User(dbEntity.getId(), dbEntity.getFirstName(), dbEntity.getLastName(), extractHouseholdsFromHouseholdUser(dbEntity.getHouseholdDBEntitySet()));
    }

    private static List<Household> extractHouseholdsFromHouseholdUser(Set<HouseholdUserMappingDBEntity> householdUserMappingDBEntitySet) {
        List<Household> households = new LinkedList<>();
        for (HouseholdUserMappingDBEntity householdUserMappingDBEntity : householdUserMappingDBEntitySet) {
            households.add(mapDBEntityToModel(householdUserMappingDBEntity.getHousehold()));
        }
        return households;
    }

    private static Household mapDBEntityToModel(HouseholdDBEntity dbEntity) {
        return new Household(dbEntity.getId(), dbEntity.getStreet(), dbEntity.getStreetNo(), dbEntity.getDoorNo(),
                dbEntity.getCity(), dbEntity.getZip(), dbEntity.getCountry(), HouseholdType.valueOf(dbEntity.getType()),
                dbEntity.getSize(), dbEntity.getResidentsNo());
    }
}
