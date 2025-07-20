package com.yugrow.dree.payload;

import com.fasterxml.jackson.databind.JsonNode;
import com.yugrow.dree.entity.Event;
import com.yugrow.dree.entity.UserProfile;

import java.util.List;

public record EvaluationRequest(
    JsonNode rule,
    List<Event> events,
    UserProfile profile
) {}
