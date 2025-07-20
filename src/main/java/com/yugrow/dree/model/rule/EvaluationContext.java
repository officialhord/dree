package com.yugrow.dree.model.rule;

import com.yugrow.dree.entity.Event;
import com.yugrow.dree.entity.UserProfile;

import java.time.ZonedDateTime;
import java.util.List;

public record EvaluationContext(
        ZonedDateTime evaluationTime,
        List<Event> events,
        UserProfile userProfile
) {
}