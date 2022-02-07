package com.ita.edu.teachua.api.models.reset_password;


import lombok.Data;

@Data
public class ResetPassword {
    private Integer id;
    private String email;
    private String password;
    private String verificationCode;

}
