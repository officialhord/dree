package com.yugrow.dree.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yugrow.dree.entity.ActionableRule;
import com.yugrow.dree.entity.Event;
import com.yugrow.dree.entity.UserProfile;
import com.yugrow.dree.model.rule.EvaluationContext;
import com.yugrow.dree.payload.EvaluationResult;
import com.yugrow.dree.repository.EventRepository;
import com.yugrow.dree.repository.RuleRepository;
import com.yugrow.dree.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleEngineService {

    private final RuleRepository ruleRepository;
    private final EventRepository eventRepository;
    private final UserProfileRepository userProfileRepository;
    private final ActionService actionService;


    public EvaluationResult evaluate(String ruleId, String userId) {
        ActionableRule rule = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found with id: " + ruleId));

        UserProfile profile = userProfileRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User profile not found with id: " + userId));
        ZonedDateTime eventWindowStart = ZonedDateTime.now().minusDays(30);
        List<Event> events = eventRepository.findByUserIdAndTimestampAfter(userId, eventWindowStart);

        EvaluationContext context = new EvaluationContext(ZonedDateTime.now(), events, profile);
        boolean triggered = rule.conditions().evaluate(context);

        if (triggered) {
            rule.actions().forEach(actionService::execute);
            return new EvaluationResult(true, rule.actions());
        } else {
            return new EvaluationResult(false, Collections.emptyList());
        }
    }
}