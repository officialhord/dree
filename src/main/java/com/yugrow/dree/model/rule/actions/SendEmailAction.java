package com.yugrow.dree.model.rule.actions;


import com.yugrow.dree.model.rule.Action;

public class SendEmailAction extends Action {

    @Override
    public String execute() {
        return "Email has been sent successfully.";
    }
}
