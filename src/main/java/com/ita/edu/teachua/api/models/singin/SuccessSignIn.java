package com.ita.edu.teachua.api.models.singin;

import lombok.Data;

@Data
public class SuccessSignIn {
    private Integer id;
    private String email;
    private String accessToken;
}
