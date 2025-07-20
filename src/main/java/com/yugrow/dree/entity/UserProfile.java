package com.yugrow.dree.entity;

import com.yugrow.dree.payload.CreateProfileRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@Document(collection = "user_profiles")
public class UserProfile {

    @Id
    private String id;
    private String email;
    private String country;
    private String accountType;


    public UserProfile(CreateProfileRequest request) {
        UserProfile.builder()
                .id(UUID.randomUUID().toString())
                .email(request.getEmail())
                .country(request.getCountry())
                .accountType(request.getAccountType())
                .build();
    }
}