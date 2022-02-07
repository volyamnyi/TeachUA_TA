package com.ita.edu.teachua.api.models.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SuccessRegistration {
    private Integer id;
    private String email;
    private String roleName;
}
