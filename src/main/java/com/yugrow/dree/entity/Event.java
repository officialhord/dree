package com.yugrow.dree.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime;
import java.util.Map;

@Data
@Document(collection = "events")
public class Event {
    private String name;
    private ZonedDateTime timestamp;
    private String userId;
    private Map<String, Object> properties;
}