package com.yugrow.dree.entity;

import com.yugrow.dree.payload.CreateEventRequest;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@Document(collection = "events")
public class Event {

    @Id
    private String id;
    private String name;
    private ZonedDateTime timestamp;
    private String userId;
    private Map<String, Object> properties;

    public Event(CreateEventRequest request) {
        this.id = UUID.randomUUID().toString();
        this.name = request.getName();
        this.timestamp = request.getTimestamp();
        this.userId = request.getUserId();
        this.properties = request.getProperties();
    }
}