package at.fhv.se.platform.adapter.postgresdb;

import at.fhv.se.platform.adapter.postgresdb.mapper.UserDBEntity;
import at.fhv.se.platform.domain.port.outbound.persistence.UserRepository;
import at.fhv.se.platform.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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
    public void save(User user) {
        this.postgresJPAUser.save(mapModelToDBEntity(user));
    }

    @Override
    public List<User> getAllUsers() {
        return this.postgresJPAUser.findAll().stream()
                .map(PostgresUserRepository::mapDBEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public User getUser(String id) {
        Optional<UserDBEntity> userDBEntityOptional = this.postgresJPAUser.findById(id);
        return userDBEntityOptional.map(PostgresUserRepository::mapDBEntityToModel).orElse(null);
    }

    private static UserDBEntity mapModelToDBEntity(User model){
        return new UserDBEntity(model.getFirstName(), model.getLastName());
    }

    private static User mapDBEntityToModel(UserDBEntity dbEntity){
        return new User(dbEntity.getId(), dbEntity.getFirstName(), dbEntity.getFirstName());
    }
}
