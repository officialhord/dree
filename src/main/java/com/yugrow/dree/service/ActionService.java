package com.yugrow.dree.service;

import com.yugrow.dree.model.rule.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
    private static final Logger logger = LoggerFactory.getLogger(ActionService.class);

    public void execute(Action action) {

        logger.info("EXECUTING ACTION: {}", action);
        // This would integrate with email services, databases, etc.
        // For example, if ("send_email".equals(action.getType())) {
        //     emailService.send(action.getProperties().get("template"));
        // }
    }
}