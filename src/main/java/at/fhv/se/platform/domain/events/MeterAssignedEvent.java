package at.fhv.se.platform.domain.events;

import java.time.LocalDateTime;


public class MeterAssignedEvent extends HouseholdEvent {
    
    private String meterId;

    public MeterAssignedEvent(String entityId, LocalDateTime timestamp, String meterId) {
        super(entityId, timestamp);
        this.meterId = meterId;
    }


    public String getMeterId() {
        return meterId;
    }

    private MeterAssignedEvent() {}

    
}
