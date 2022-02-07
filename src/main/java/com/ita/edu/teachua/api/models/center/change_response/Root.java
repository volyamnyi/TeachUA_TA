package com.ita.edu.teachua.api.models.center.change_response;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    public Integer id;
    public String name;
    public List<Location> locations;
    public String description;
    public String urlWeb;
    public String urlBackgroundPicture;
    //
    public String email;
    public String phones;
    public String urlLogo;
    public List<Integer> clubsId;
    public Integer userId;
    public String contacts;
    public Integer centerExternalId;
}
