package com.ita.edu.teachua.api.models.center.center_response;

import lombok.Data;

import java.util.List;

@Data
public class CenterRoot {
    private Integer id;
    private Integer userId;
    private String name;
    private Object email;
    private Object phones;
    private String description;
    private Object urlWeb;
    private Object urlLogo;
    private String contacts;
    private List<Locations> locations;
}
