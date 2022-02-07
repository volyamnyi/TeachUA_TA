package com.ita.edu.teachua.api.models.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUser {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String roleName;
}