package com.ita.edu.teachua.api.models.feedback.feedback_response;

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
    private String provider;
    private Object providerId;
    private Boolean status;
    private String verificationCode;
}