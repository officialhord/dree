package com.yugrow.dree.entity;

import com.yugrow.dree.payload.CreateProfileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_profiles")
public class UserProfile {

    @Id
    private String id;
    private String email;
    private String country;
    private String accountType;


    public UserProfile(CreateProfileRequest request) {
        this.id = UUID.randomUUID().toString();
        this.email = request.getEmail();
        this.country = request.getCountry();
        this.accountType = request.getAccountType();
    }
}