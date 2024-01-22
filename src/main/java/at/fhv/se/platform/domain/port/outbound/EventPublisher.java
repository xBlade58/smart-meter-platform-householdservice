package at.fhv.se.platform.domain.port.outbound;

import at.fhv.se.platform.domain.events.HouseholdEvent;

// secondary port
public interface EventPublisher {
    void publishHosueholdEvent(HouseholdEvent ev);
}
