package at.fhv.se.platform.domain.port.inbound.household;

public interface AssignMeterToHouseholdUseCase {
    void assign(String householdId, String meterId);
}
