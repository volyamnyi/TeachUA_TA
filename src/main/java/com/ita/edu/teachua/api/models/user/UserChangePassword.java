package com.ita.edu.teachua.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserChangePassword {
    private String oldPassword;
    private String newPassword;
    private String newPasswordVerify;
}
