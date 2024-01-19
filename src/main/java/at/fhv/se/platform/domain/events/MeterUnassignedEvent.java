package at.fhv.se.platform.domain.events;

public class MeterUnassignedEvent extends HouseholdEvent {

    private String meterId;

    public MeterUnassignedEvent(String meterId) {
        super();
        this.meterId = meterId;
        this.eventType = "MeterUnassignedEvent";
        this.meterId = meterId;
    }


    public String getMeterId() {
        return meterId;
    }

    private MeterUnassignedEvent() {}    

    
}
