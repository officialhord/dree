package com.yugrow.dree.repository;

import com.yugrow.dree.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.ZonedDateTime;
import java.util.List;
public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findByUserIdAndTimestampAfter(String userId, ZonedDateTime startTime);
}