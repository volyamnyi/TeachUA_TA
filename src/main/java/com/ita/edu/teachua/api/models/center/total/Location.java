package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

@Data
public class Location {
    public int id;
    public String name;
    public String address;
    public String cityName;
    public String districtName;
    public String stationName;
    public City city;
    public int cityId;
    public int districtId;
    public int stationId;
    public Object clubId;
    public Object coordinates;
    public double longitude;
    public double latitude;
    public String phone;
    public Distict district;
    public Station station;
    public String club;
    public Center2 center;
}
