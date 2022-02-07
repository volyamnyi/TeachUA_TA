package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Club2 {
    public int id;
    public int ageFrom;
    public int ageTo;
    public String name;
    public String description;
    public String urlWeb;
    public String urlLogo;
    public String urlBackground;
    public List<String> urlGallery;
    public String workTime;
    public int rating;
    public int feedbackCount;
    public boolean isOnline;
    public List<Location> locations;
    public List<Feedback> feedbacks;
    public List<Category> categories;
    public User user;
    public Center2 center;
    public boolean isApproved;
    public String contacts;
    public int clubExternalId;
    public int centerExternalId;
}
