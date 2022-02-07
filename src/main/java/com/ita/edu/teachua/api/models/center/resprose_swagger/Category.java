package com.ita.edu.teachua.api.models.center.resprose_swagger;

import lombok.AllArgsConstructor;
import lombok.Data;

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
}
