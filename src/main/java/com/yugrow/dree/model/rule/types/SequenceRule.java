package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.entity.Event;
import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

@TypeAlias("sequence")
public record SequenceRule(List<String> events, int withinMinutes) implements Rule {

    @Override
    public boolean evaluate(EvaluationContext context) {
        if (events == null || events.isEmpty()) {
            return true;
        }

        List<Event> userEvents = context.events().stream()
                .sorted(Comparator.comparing(Event::getTimestamp))
                .toList();

        for (int i = 0; i < userEvents.size(); i++) {
            if (matches(userEvents, i, context.evaluationTime())) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(List<Event> userEvents, int startIndex, ZonedDateTime evaluationTime) {
        if (!userEvents.get(startIndex).getName().equals(events.get(0))) {
            return false;
        }

        ZonedDateTime firstEventTime = userEvents.get(startIndex).getTimestamp();
        if (firstEventTime.isBefore(evaluationTime.minusMinutes(withinMinutes))) {
            return false;
        }

        int currentEventInSequence = 1;

        for (int j = startIndex + 1; j < userEvents.size() && currentEventInSequence < events.size(); j++) {
            Event currentEvent = userEvents.get(j);
            if (currentEvent.getName().equals(events.get(currentEventInSequence))) {
                if (currentEvent.getTimestamp().isAfter(firstEventTime.plusMinutes(withinMinutes))) {
                    return false;
                }
                currentEventInSequence++;
            }
        }
        return currentEventInSequence == events.size();
    }
}