package at.fhv.se.platform.application.port.inbound.household;

import at.fhv.se.platform.application.exceptions.HouseholdNotFoundException;

public interface AssignMeterToHouseholdUseCase {
    void assign(String householdId, String meterId) throws HouseholdNotFoundException;
}
