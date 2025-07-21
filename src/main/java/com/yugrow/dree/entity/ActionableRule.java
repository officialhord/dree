package com.yugrow.dree.entity;

import com.yugrow.dree.model.rule.Action;
import com.yugrow.dree.model.rule.Rule;
import com.yugrow.dree.payload.CreateRuleRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "rules")
public record ActionableRule(
        @Id String ruleId,
        String name,
        Rule conditions,
        List<Action> actions
) {
    public ActionableRule(CreateRuleRequest rule) {
        this(
                UUID.randomUUID().toString(),
                rule.getName(),
                rule.getConditions(),
                rule.getActions()
        );
    }
}