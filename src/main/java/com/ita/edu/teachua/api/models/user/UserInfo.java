package com.ita.edu.teachua.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserInfo {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String roleName;
    private Object urlLogo;
    private String status;
}
