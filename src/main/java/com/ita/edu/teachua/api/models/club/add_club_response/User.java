package com.ita.edu.teachua.api.models.club.add_club_response;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private Role role;
    private String provider;
    private String providerId;
    private Boolean status;
    private String verificationCode;
}
