package com.yugrow.dree.model.rule.actions;

import com.yugrow.dree.model.rule.Action;

public class ApplyBonusAction extends Action {
    @Override
    public String execute() {
        return "Bonus has been applied to user profile successfully.";
    }
}
