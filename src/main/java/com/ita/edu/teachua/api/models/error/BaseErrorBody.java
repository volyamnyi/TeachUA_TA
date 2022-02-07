package com.ita.edu.teachua.api.models.error;

import lombok.Data;

@Data
public class BaseErrorBody {
    private Integer status;
    private String message;

    private Long timestamp;
    private String error;
    private String path;
}
