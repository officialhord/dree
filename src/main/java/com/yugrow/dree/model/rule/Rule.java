package com.yugrow.dree.model.rule;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.yugrow.dree.model.rule.types.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndRule.class, name = "and"),
        @JsonSubTypes.Type(value = OrRule.class, name = "or"),
        @JsonSubTypes.Type(value = NotRule.class, name = "not"),
        @JsonSubTypes.Type(value = AttributeMatchRule.class, name = "attribute_match"),
        @JsonSubTypes.Type(value = EventOccurredRule.class, name = "event_occurred"),
        @JsonSubTypes.Type(value = NotOccurredRule.class, name = "not_occurred"),
        @JsonSubTypes.Type(value = EventCountRule.class, name = "event_count"),
        @JsonSubTypes.Type(value = SequenceRule.class, name = "sequence")
})
public interface Rule {

    boolean evaluate(EvaluationContext context);
}