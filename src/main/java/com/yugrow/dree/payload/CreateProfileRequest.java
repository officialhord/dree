package com.yugrow.dree.payload;

import lombok.Data;

@Data
public class CreateProfileRequest {

    private String email;

    private String country;

    private String accountType;

}
