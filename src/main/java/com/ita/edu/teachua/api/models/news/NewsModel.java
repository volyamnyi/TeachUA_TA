package com.ita.edu.teachua.api.models.news;

import lombok.Data;

@Data
public class NewsModel {
    private Integer id;
    private String title;
    private String description;
    private String urlTitleLogo;
    private Boolean isActive;
    private String date;
    private Integer userId;
}