package com.yugrow.dree.controller;

import com.yugrow.dree.entity.ActionableRule;
import com.yugrow.dree.entity.Event;
import com.yugrow.dree.entity.UserProfile;
import com.yugrow.dree.model.rule.Rule;
import com.yugrow.dree.payload.CreateEventRequest;
import com.yugrow.dree.payload.CreateProfileRequest;
import com.yugrow.dree.payload.CreateRuleRequest;
import com.yugrow.dree.payload.EvaluationResult;
import com.yugrow.dree.repository.EventRepository;
import com.yugrow.dree.repository.RuleRepository;
import com.yugrow.dree.repository.UserProfileRepository;
import com.yugrow.dree.service.RuleEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<?> createRule(@RequestBody CreateRuleRequest rule) {
        Optional<ActionableRule> existingRule = ruleRepository.findByName(rule.getName());
        if (existingRule.isPresent())
            return ResponseEntity.badRequest().body("This rule already exists");
        return ResponseEntity.ok(ruleRepository.save(new ActionableRule(rule)));
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody CreateEventRequest event) {
        return ResponseEntity.ok(eventRepository.save(new Event(event)));
    }

    @PostMapping("/profiles")
    public ResponseEntity<?> createOrUpdateProfile(@RequestBody CreateProfileRequest profile) {
        Optional<UserProfile> existingProfile = userProfileRepository.findByEmail(profile.getEmail());
        if (existingProfile.isPresent()) {
            return ResponseEntity.badRequest().body("Profile with this email already exists");
        }
        return ResponseEntity.ok(userProfileRepository.save(new UserProfile(profile)));
    }
}