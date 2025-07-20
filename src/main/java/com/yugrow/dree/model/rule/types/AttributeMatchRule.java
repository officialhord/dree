package com.yugrow.dree.model.rule.types;

import com.yugrow.dree.entity.UserProfile;
import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.model.rule.Rule;
import org.springframework.data.annotation.TypeAlias;

import java.util.Objects;

@TypeAlias("attribute_match")
public record AttributeMatchRule(String field, String operator, String value) implements Rule {

    @Override
    public boolean evaluate(EvaluationContext context) {
        UserProfile profile = context.userProfile();
        if (profile == null) {
            return false;
        }

        String profileValue = switch (field) {
            case "country" -> profile.getCountry();
            case "accountType" -> profile.getAccountType();
            case "email" -> profile.getEmail();
            default -> null;
        };

        if (profileValue == null) {
            return false;
        }

        return switch (operator) {
            case "==" -> Objects.equals(profileValue, value);
            case "!=" -> !Objects.equals(profileValue, value);
            default -> throw new IllegalArgumentException("Unsupported operator in AttributeMatchRule: " + operator);
        };
    }
}