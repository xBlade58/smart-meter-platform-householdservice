package at.fhv.se.platform.adapter.redis;

import at.fhv.se.platform.domain.events.HouseholdEvent;
import at.fhv.se.platform.application.port.outbound.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
