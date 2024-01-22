package at.fhv.se.platform.adapter.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.platform.domain.events.HouseholdEvent;
import at.fhv.se.platform.domain.port.outbound.EventPublisher;

@Service
public class RedisPublisher implements EventPublisher {

    @Autowired
    private RedisClient redisClient;

    @Override
    public void publishHosueholdEvent(HouseholdEvent ev) {
        redisClient.addEvent("household", ev);
        System.out.println("Event published with ID = " + ev.getId());
    }
    
}
