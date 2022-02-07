package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Club {
    public int id;
    public int ageFrom;
    public int ageTo;
    public String name;
    public String description;
    public Object urlWeb;
    public String urlLogo;
    public String urlBackground;
    public List<UrlGallery> urlGallery;
    public Object workTime;
    public List<Category> categories;
    public Object user;
    public Center2 center;
    public double rating;
    public List<Location> locations;
    public Object isApproved;
    public Object isOnline;
    public int feedbackCount;
    public List<Contact> contacts;
}
