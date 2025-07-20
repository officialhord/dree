package com.yugrow.dree.model.rule;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.yugrow.dree.model.rule.actions.ApplyBonusAction;
import com.yugrow.dree.model.rule.actions.LogAnalyticsAction;
import com.yugrow.dree.model.rule.actions.SendEmailAction;
import com.yugrow.dree.model.rule.actions.UpdateUserStatusAction;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SendEmailAction.class, name = "send_email"),
        @JsonSubTypes.Type(value = UpdateUserStatusAction.class, name = "update_user_status"),
        @JsonSubTypes.Type(value = ApplyBonusAction.class, name = "apply_bonus"),
        @JsonSubTypes.Type(value = LogAnalyticsAction.class, name = "log_to_analytics")
})
public abstract class Action {
    public abstract String execute();
}