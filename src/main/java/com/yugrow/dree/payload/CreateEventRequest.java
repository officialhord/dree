package com.yugrow.dree.payload;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
public class CreateEventRequest {

    private String name;
    private ZonedDateTime timestamp;
    private String userId;
    private Map<String, Object> properties;

}
