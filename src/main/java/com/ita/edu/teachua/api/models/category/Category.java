package com.ita.edu.teachua.api.models.category;

import com.ita.edu.teachua.api.clients.CategoryClient;
import lombok.Data;

@Data
public class Category {
    private Integer id;
    private Integer sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;
}
