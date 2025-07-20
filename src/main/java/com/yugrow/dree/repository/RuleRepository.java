package com.yugrow.dree.repository;

import com.yugrow.dree.entity.ActionableRule;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface RuleRepository extends MongoRepository<ActionableRule, String> {}