package at.fhv.se.platform.adapter.postgresdb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Justin Ströhle
 * 11.01.2024
 */

@Entity
@Table(name = "household_user")
public class HouseholdUserMappingDBEntity {
    @EmbeddedId
    private HouseholdUserKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserDBEntity user;

    @ManyToOne
    @MapsId("householdId")
    @JoinColumn(name = "household_id")
    private HouseholdDBEntity household;

    public HouseholdUserMappingDBEntity() {
    }

    public HouseholdUserMappingDBEntity(UserDBEntity user, HouseholdDBEntity household) {
        this.user = user;
        this.household = household;
        this.id = new HouseholdUserKey(user.getId(), household.getId());
    }

    public UserDBEntity getUser() {
        return user;
    }

    public HouseholdDBEntity getHousehold() {
        return household;
    }

    @Embeddable
    public static class HouseholdUserKey implements Serializable {
        UUID userId;
        UUID householdId;

        public HouseholdUserKey() {
        }

        public HouseholdUserKey(UUID userId, UUID householdId) {
            this.userId = userId;
            this.householdId = householdId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HouseholdUserKey that)) return false;
            return Objects.equals(userId, that.userId) && Objects.equals(householdId, that.householdId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, householdId);
        }
    }
}
