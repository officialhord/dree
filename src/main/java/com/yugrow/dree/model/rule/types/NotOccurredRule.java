package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

import java.time.ZonedDateTime;


@TypeAlias("not_occurred")
public record NotOccurredRule(String event, int withinMinutes) implements Rule {

    @Override
    public boolean evaluate(EvaluationContext context) {
        ZonedDateTime windowStart = context.evaluationTime().minusMinutes(withinMinutes);

        return context.events().stream()
            .noneMatch(e -> e.getName().equals(event) && !e.getTimestamp().isBefore(windowStart));
    }
}