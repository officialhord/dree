package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@TypeAlias("or")
public record OrRule(List<Rule> rules) implements Rule {

    @Override
    public boolean evaluate(EvaluationContext context) {
        if (rules == null || rules.isEmpty()) {
            return false;
        }
        for (Rule rule : rules) {
            if (rule.evaluate(context)) {
                return true;
            }
        }
        return false;
    }
}