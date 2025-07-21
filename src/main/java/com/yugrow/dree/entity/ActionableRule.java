package com.yugrow.dree.entity;

import com.yugrow.dree.model.rule.Action;
import com.yugrow.dree.model.rule.Rule;
import com.yugrow.dree.payload.CreateRuleRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;


@Data
@Document(collection = "rules")
@AllArgsConstructor
@NoArgsConstructor
public class ActionableRule {
    @Id
    String ruleId;
    String name;
    Rule type;
    List<Action> actions;

    public ActionableRule(CreateRuleRequest rule) {
        this.ruleId = UUID.randomUUID().toString();
        this.name = rule.getName();
        this.type = rule.getConditions();
        this.actions = rule.getActions();
    }
}