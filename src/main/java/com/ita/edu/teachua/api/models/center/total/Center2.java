
package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Center2 {
    public int id;
    public String name;
    public String contacts;
    public String urlBackgroundPicture;
    public String description;
    public String urlWeb;
    public String urlLogo;
    public List<Object> locations;
    public List<Object> clubs;
    public User user;
    public int centerExternalId;
    public int rating;
    public int clubCount;
    public String email;
    public String phones;
    public String socialLinks;
}

