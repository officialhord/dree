package com.yugrow.dree.model.rule.actions;

import com.yugrow.dree.model.rule.Action;

public class UpdateUserStatusAction extends Action {
    @Override
    public String execute() {
        return "User status has been updated successfully.";
    }
}
