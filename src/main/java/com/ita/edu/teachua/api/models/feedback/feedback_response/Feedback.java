package com.ita.edu.teachua.api.models.feedback.feedback_response;

import lombok.Data;

import java.util.List;

@Data
public class Feedback {
    private Integer id;
    private Double rate;
    private String text;
    private List<Integer> date;
    private User user;
    private Club club;
}
