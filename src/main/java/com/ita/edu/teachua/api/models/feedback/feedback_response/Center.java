package com.ita.edu.teachua.api.models.feedback.feedback_response;

import lombok.Data;

import java.util.List;

@Data
public class Center{
    private Integer id;
    private String name;
    private String contacts;
    private Object urlBackgroundPicture;
    private String description;
    private Object urlWeb;
    private Object urlLogo;
    private List<Location> locations;
    private List<Integer> clubs;
    private User user;
    private Integer centerExternalId;
    private Double rating;
    private Integer clubCount;
}