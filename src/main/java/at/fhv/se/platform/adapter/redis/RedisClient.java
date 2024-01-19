package at.fhv.se.platform.adapter.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import at.fhv.se.platform.domain.events.HouseholdEvent;


@Service
public class RedisClient {
    
    @Autowired
    private RedisTemplate<String, HouseholdEvent> redisTemplate;


    public void addEvent(String key, HouseholdEvent ev) {
        ObjectRecord<String, HouseholdEvent> record = StreamRecords.newRecord().ofObject(ev).withStreamKey(key);
        try {
            redisTemplate.opsForStream().add(record);
        } catch(Exception e) {
            e.printStackTrace();
        }    
    }
}
