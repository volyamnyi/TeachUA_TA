package com.ita.edu.teachua.api.models.banner;


import lombok.Data;

@Data
public class BannerModel {
    private Integer id;
    private String title;
    private String subtitle;
    private String link;
    private String picture;
    private Integer sequenceNumber;
}
