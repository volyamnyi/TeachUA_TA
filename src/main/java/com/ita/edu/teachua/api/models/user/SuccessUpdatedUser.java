package com.ita.edu.teachua.api.models.user;

import lombok.Data;

@Data
public class SuccessUpdatedUser {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private String status;
    private String roleName;
}
