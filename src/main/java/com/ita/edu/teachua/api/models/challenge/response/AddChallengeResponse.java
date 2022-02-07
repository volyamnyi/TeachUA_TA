package com.ita.edu.teachua.api.models.challenge.response;

import lombok.Data;

@Data
public class AddChallengeResponse {
    private String name;
    private String title;
    private String description;
    private String picture;
    private String sortNumber;
}
