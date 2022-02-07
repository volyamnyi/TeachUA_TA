package com.ita.edu.teachua.api.models.station;

import lombok.Data;

@Data
public class StationResponseModel {
    private Integer id;
    private String name;
    private String cityName;
    private String districtName;
}
