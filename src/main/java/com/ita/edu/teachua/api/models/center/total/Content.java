package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Content {
    public int id;
    public String name;
    public String urlBackgroundPicture;
    public String email;
    public String phones;
    public String description;
    public String urlWeb;
    public String urlLogo;
    public String socialLinks;
    public User user;
    public List<Location> locations;
    public List<Club> clubs;
    public List<Contact> contacts;
}
