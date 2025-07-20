package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

import java.time.ZonedDateTime;

@TypeAlias("event_count")
public record EventCountRule(String event, String operator, int value, int withinDays) implements Rule {

    @Override
    public boolean evaluate(EvaluationContext context) {
        ZonedDateTime windowStart = context.evaluationTime().minusDays(withinDays);

        long count = context.events().stream()
            .filter(e -> e.getName().equals(event))
            .filter(e -> !e.getTimestamp().isBefore(windowStart))
            .count();

        return switch (operator) {
            case ">" -> count > value;
            case ">=" -> count >= value;
            case "<" -> count < value;
            case "<=" -> count <= value;
            case "==" -> count == value;
            case "!=" -> count != value;
            default -> throw new IllegalArgumentException("Unsupported operator in EventCountRule: " + operator);
        };
    }
}