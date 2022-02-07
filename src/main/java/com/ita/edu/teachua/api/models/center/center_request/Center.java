package com.ita.edu.teachua.api.models.center.center_request;

import lombok.Data;

import java.util.List;

@Data
public class Center {
    private String name;
    private String description;
    private String userId;
    private String contacts;
    private List<Location> locations;
    private List<Integer> clubsId;
}
