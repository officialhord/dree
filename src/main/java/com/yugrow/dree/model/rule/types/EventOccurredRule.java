package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;

import java.time.ZonedDateTime;

@Data
//@TypeAlias("event_occurred")
public final class EventOccurredRule extends Rule {

    String event;
    int withinMinutes;

    @Override
    public boolean evaluate(EvaluationContext context) {
        ZonedDateTime windowStart = context.evaluationTime().minusMinutes(withinMinutes);

        return context.events().stream()
                .anyMatch(e -> e.getName().equals(event) && !e.getTimestamp().isBefore(windowStart));
    }
}