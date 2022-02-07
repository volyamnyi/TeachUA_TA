package com.ita.edu.teachua.api.models.category.search_response;

import lombok.Data;

@Data
public class Content {
    public int id;
    public int sortby;
    public String name;
    public String description;
    public String urlLogo;
    public String backgroundColor;
    public String tagBackgroundColor;
    public String tagTextColor;
}
