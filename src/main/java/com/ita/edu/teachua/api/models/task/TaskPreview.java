package com.ita.edu.teachua.api.models.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskPreview {
    private Integer id;
    private String name;
    private String headerText;
    private String picture;
    private String startDate;
}
