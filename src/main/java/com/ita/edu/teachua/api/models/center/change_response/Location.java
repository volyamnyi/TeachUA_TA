package com.ita.edu.teachua.api.models.center.change_response;

import lombok.Data;

@Data
public class Location {
    private Integer id;
    private String name;
    private String address;
    private Integer cityId;
    private Integer districtId;
    private Integer stationId;
    private String cityName;
    private String districtName;
    private String stationName;
    private Object coordinates;
    private Double longitude;
    private Double latitude;
    private Integer centerId;
    private Object clubId;
    private String phone;
}
