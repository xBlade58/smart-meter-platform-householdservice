package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.model.HouseholdDBEntity;
import at.fhv.se.platform.adapter.postgresdb.model.HouseholdUserMappingDBEntity;
import at.fhv.se.platform.adapter.postgresdb.model.UserDBEntity;
import at.fhv.se.platform.domain.model.Household;
import at.fhv.se.platform.domain.model.HouseholdType;
import at.fhv.se.platform.domain.model.User;
import at.fhv.se.platform.application.port.outbound.persistence.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Justin Ströhle
 * 14.12.2023
 */

@Repository
public class PostgresHouseholdRepository implements HouseholdRepository {

    @Autowired
    private PostgresJPAHousehold postgresJPAHousehold;

    @Autowired
    private PostgresJPAHouseholdUser postgresJPAHouseholdUser;

    @Override
    public String save(Household household) {
        return this.postgresJPAHousehold.save(mapModelToDBEntity(household)).getId().toString();
    }

    @Override
    public List<Household> getAllHouseholds() {
        return this.postgresJPAHousehold.findAll().stream()
                .map(PostgresHouseholdRepository::mapDBEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Household getHousehold(String id) {
        Optional<HouseholdDBEntity> userDBEntityOptional = this.postgresJPAHousehold.findById(UUID.fromString(id));
        return userDBEntityOptional.map(PostgresHouseholdRepository::mapDBEntityToModel).orElse(null);
    }

    @Override
    public void assignUser(User user, Household household) {

        this.postgresJPAHouseholdUser.save(new HouseholdUserMappingDBEntity(
                mapModelToDBEntityId(user),
                mapModelToDBEntityId(household)
        ));
    }

    @Override
    public List<Household> getHouseholdsFromUser(User user) {
        return this.postgresJPAHousehold.findByUserID(user.getId()).stream()
                .map(PostgresHouseholdRepository::mapDBEntityToModel)
                .collect(Collectors.toList());
    }

    private static HouseholdDBEntity mapModelToDBEntity(Household model) {
        return new HouseholdDBEntity(model.getStreet(), model.getStreetNo(), model.getDoorNo(),
                model.getCity(), model.getZip(), model.getCountry(), model.getType().toString(), model.getSize(),
                model.getResidentsNo());
    }

    private static HouseholdDBEntity mapModelToDBEntityId(Household model) {
        return new HouseholdDBEntity(model.getId(), model.getStreet(), model.getStreetNo(), model.getDoorNo(),
                model.getCity(), model.getZip(), model.getCountry(), model.getType().toString(), model.getSize(),
                model.getResidentsNo());
    }


    private static Household mapDBEntityToModel(HouseholdDBEntity dbEntity) {
        return new Household(dbEntity.getId(), dbEntity.getStreet(), dbEntity.getStreetNo(), dbEntity.getDoorNo(),
                dbEntity.getCity(), dbEntity.getZip(), dbEntity.getCountry(), HouseholdType.valueOf(dbEntity.getType()),
                dbEntity.getSize(), dbEntity.getResidentsNo(), extractUsersFromHouseholdUser(dbEntity.getUsers()));
    }

    private static UserDBEntity mapModelToDBEntity(User model) {
        return new UserDBEntity(model.getFirstName(), model.getLastName());
    }

    private static UserDBEntity mapModelToDBEntityId(User model) {
        return new UserDBEntity(model.getId(), model.getFirstName(), model.getLastName());
    }


    private static List<User> extractUsersFromHouseholdUser(Set<HouseholdUserMappingDBEntity> householdUserMappingDBEntitySet) {
        List<User> users = new LinkedList<>();
        for (HouseholdUserMappingDBEntity householdUserMappingDBEntity : householdUserMappingDBEntitySet) {
            users.add(mapDBEntityToModel(householdUserMappingDBEntity.getUser()));
        }
        return users;
    }

    private static User mapDBEntityToModel(UserDBEntity userDBEntity) {
        return new User(userDBEntity.getId(), userDBEntity.getFirstName(), userDBEntity.getLastName());
    }

    @Override
    public void assignMeter(UUID householdId, String meterId) {
        postgresJPAHousehold.assignMeter(householdId, meterId);
    }
}
