package com.yugrow.dree.service;

import com.yugrow.dree.model.rule.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActionService {

    public void execute(Action action) {
        log.info("EXECUTING ACTION: {}", action);
        log.info(action.execute());
    }
}