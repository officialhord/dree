package com.yugrow.dree.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_profiles")
public class UserProfile {
    @Id
    private String id;
    private String email;
    private String country;
    private String accountType;
}