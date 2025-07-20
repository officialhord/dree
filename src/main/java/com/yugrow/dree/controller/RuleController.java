package com.yugrow.dree.controller;

import com.yugrow.dree.entity.ActionableRule;
import com.yugrow.dree.entity.Event;
import com.yugrow.dree.entity.UserProfile;
import com.yugrow.dree.payload.EvaluationResult;
import com.yugrow.dree.repository.EventRepository;
import com.yugrow.dree.repository.RuleRepository;
import com.yugrow.dree.repository.UserProfileRepository;
import com.yugrow.dree.service.RuleEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RuleController {

    private final RuleEngineService ruleEngineService;
    private final RuleRepository ruleRepository;
    private final EventRepository eventRepository;
    private final UserProfileRepository userProfileRepository;


    @PostMapping("/rules/{ruleId}/evaluate/user/{userId}")
    public ResponseEntity<EvaluationResult> evaluateRule(
            @PathVariable String ruleId,
            @PathVariable String userId) {
        EvaluationResult result = ruleEngineService.evaluate(ruleId, userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/rules")
    public ResponseEntity<ActionableRule> createRule(@RequestBody ActionableRule rule) {
        return ResponseEntity.ok(ruleRepository.save(rule));
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventRepository.save(event));
    }

    @PostMapping("/profiles")
    public ResponseEntity<UserProfile> createOrUpdateProfile(@RequestBody UserProfile profile) {
        return ResponseEntity.ok(userProfileRepository.save(profile));
    }
}