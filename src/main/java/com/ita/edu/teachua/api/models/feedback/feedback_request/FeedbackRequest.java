package com.ita.edu.teachua.api.models.feedback.feedback_request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeedbackRequest {
    private Integer id;
    private Float rate;
    private String text;
    private Integer userId;
    private Integer clubId;
}