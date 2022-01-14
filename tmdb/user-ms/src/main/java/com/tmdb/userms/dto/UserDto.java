package com.tmdb.userms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String userId;
    private String encryptedPassword;
}
