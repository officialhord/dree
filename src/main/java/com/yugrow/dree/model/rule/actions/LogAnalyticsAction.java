package com.yugrow.dree.model.rule.actions;

import com.yugrow.dree.model.rule.Action;

public class LogAnalyticsAction extends Action {
    @Override
    public String execute() {
        return "Logging action :::: Analytics data has been logged successfully.";
    }
}
