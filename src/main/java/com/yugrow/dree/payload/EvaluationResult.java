package com.yugrow.dree.payload;

import com.yugrow.dree.model.rule.Action;

import java.util.List;

public record EvaluationResult(boolean triggered, List<Action> executedActions) {
}