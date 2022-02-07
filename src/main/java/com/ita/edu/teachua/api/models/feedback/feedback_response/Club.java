package com.ita.edu.teachua.api.models.feedback.feedback_response;

import lombok.Data;

import java.util.List;

@Data
public class Club {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private Object urlWeb;
    private Object urlLogo;
    private Object urlBackground;
    private List<UrlGallery> urlGallery;
    private Object workTime;
    private Float rating;
    private Integer feedbackCount;
    private Object isOnline;
    private List<Object> locations;
    private List<FeedbackResponse> feedbacks;
    private List<Category> categories;
    private User user;
    private Center center;
    private Boolean isApproved;
    private String contacts;
    private Integer clubExternalId;
    private Integer centerExternalId;
}