package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("not")
public record NotRule(Rule rule) implements Rule {

    @Override
    public boolean evaluate(EvaluationContext context) {
        if (rule == null) {
            return true;
        }
        return !rule.evaluate(context);
    }
}