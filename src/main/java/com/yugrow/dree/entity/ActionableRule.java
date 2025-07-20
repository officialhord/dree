package com.yugrow.dree.entity;

import com.yugrow.dree.model.rule.Action;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "rules")
public record ActionableRule(
        @Id String ruleId,
        String name,
        Rule conditions,
        List<Action> actions
) {
}