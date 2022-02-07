package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

@Data
public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public String urlLogo;
    public Role role;
    public String provider;
    public String providerId;
    public boolean status;
    public String verificationCode;
}
