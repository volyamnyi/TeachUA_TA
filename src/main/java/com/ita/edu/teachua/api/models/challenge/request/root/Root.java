package com.ita.edu.teachua.api.models.challenge.request.root;

import com.ita.edu.teachua.api.models.challenge.request.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Root {
    private Integer id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private Integer sortNumber;
    private Boolean isActive;
    private List<String> tasks;
    private User user;
}
