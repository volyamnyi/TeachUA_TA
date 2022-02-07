package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    public int id;
    public int sortby;
    public String name;
    public String description;
    public String urlLogo;
    public String backgroundColor;
    public String tagBackgroundColor;
    public String tagTextColor;
    public List<String> clubs;
}
