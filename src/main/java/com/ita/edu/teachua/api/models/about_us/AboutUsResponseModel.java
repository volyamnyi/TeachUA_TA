package com.ita.edu.teachua.api.models.about_us;

import lombok.Data;

@Data
public class AboutUsResponseModel {
    private Integer id;
    private String text;
    private String picture;
    private String video;
    private Integer type;
}
