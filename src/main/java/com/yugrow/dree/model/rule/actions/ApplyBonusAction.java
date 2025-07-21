package com.yugrow.dree.model.rule.actions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yugrow.dree.model.rule.Action;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplyBonusAction extends Action {

    @Override
    public String execute() {
        return "Bonus has been applied to user profile successfully.";
    }
}
