package at.fhv.se.platform.domain.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "eventType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MeterAssignedEvent.class, name = "MeterAssignedEvent"),
        @JsonSubTypes.Type(value = MeterUnassignedEvent.class, name = "MeterUnassignedEvent")
})
public abstract class HouseholdEvent {

    private String id;
    protected String eventType;
    protected String entityId;
    protected LocalDateTime timestamp;

    public HouseholdEvent(String entityId, LocalDateTime timestamp) {
        this.id = UUID.randomUUID().toString();
        this.eventType = this.getClass().getSimpleName();
        this.entityId = entityId;
        this.timestamp = timestamp;
    }


    public String getId() {
        return id;
    }

    public String getEntityId() {
        return entityId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HouseholdEvent() {
    }

}
