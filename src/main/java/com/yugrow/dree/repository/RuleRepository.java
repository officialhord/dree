package com.yugrow.dree.repository;

import com.yugrow.dree.entity.ActionableRule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface RuleRepository extends MongoRepository<ActionableRule, String> {

    Optional<ActionableRule> findByName(String name);
}