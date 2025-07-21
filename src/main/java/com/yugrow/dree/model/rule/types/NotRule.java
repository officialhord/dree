package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;

@Data
//@TypeAlias("not")
public final class NotRule extends Rule {

    Rule rule;

    @Override
    public boolean evaluate(EvaluationContext context) {
        if (rule == null) {
            return true;
        }
        return !rule.evaluate(context);
    }
}