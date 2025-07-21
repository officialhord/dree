package com.yugrow.dree.payload;

import com.yugrow.dree.model.rule.Action;
import com.yugrow.dree.model.rule.Rule;
import lombok.Data;

import java.util.List;

@Data
public class CreateRuleRequest {

    private String name;
    private Rule conditions;
    private List<Action> actions;

}
