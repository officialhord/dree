package com.yugrow.dree.model.rule;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
// This would define the different action types that can be used in the rules engine
//    @JsonSubTypes.Type(value = SendEmailAction.class, name = "send_email"),
//    @JsonSubTypes.Type(value = UpdateUserStatusAction.class, name = "update_user_status"),
//    @JsonSubTypes.Type(value = ApplyBonusAction.class, name = "apply_bonus"),
//    @JsonSubTypes.Type(value = LogAnalyticsAction.class, name = "log_to_analytics")
})
public abstract class Action {
    public abstract String execute();
}