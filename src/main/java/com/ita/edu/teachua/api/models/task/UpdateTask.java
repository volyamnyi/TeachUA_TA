package com.ita.edu.teachua.api.models.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTask {
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private Integer challengeId;
}
