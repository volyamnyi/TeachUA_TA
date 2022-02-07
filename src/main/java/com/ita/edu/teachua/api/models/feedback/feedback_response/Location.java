package com.ita.edu.teachua.api.models.feedback.feedback_response;

import lombok.Data;

@Data
public class Location{
    private String name;
    private Integer id;
    private String address;
    private Float latitude;
    private Float longitude;
    private Object phone;
    private Object district;
    private Object station;
    private City city;
}