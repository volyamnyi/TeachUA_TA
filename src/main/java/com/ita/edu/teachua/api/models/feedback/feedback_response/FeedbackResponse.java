package com.ita.edu.teachua.api.models.feedback.feedback_response;

import lombok.Data;

import java.util.List;

@Data
public class FeedbackResponse {
    private Integer id;
    private Float rate;
    private String text;
    private List<Integer> date;
    private User user;
    private Integer club;
    private Integer userId;
    private Integer clubId;
}
