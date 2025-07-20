package com.yugrow.dree.model.rule.types;


import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@TypeAlias("and")
public record AndRule(List<Rule> rules) implements Rule {
    @Override
    public boolean evaluate(EvaluationContext context) {
        for (Rule rule : rules) {
            if (!rule.evaluate(context)) {
                return false;
            }
        }
        return true;
    }
}