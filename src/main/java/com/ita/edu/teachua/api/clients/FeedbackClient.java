package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.feedback.feedback_request.FeedbackRequest;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

public class FeedbackClient extends BaseClient {
    protected MainValueProvider valueProvider;
    private final String feedbackUrl;
    private final String feedbacksUrl;
    private String token;


    public FeedbackClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.feedbackUrl = mainValueProvider.getFeedbackUrl();
        this.feedbacksUrl = mainValueProvider.getFeedbacksUrl();
        this.token = token;
    }

    @Step("Add new feedback to the club")
    public Response addNewFeedback(FeedbackRequest feedback) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(feedback)
                .log().all()
                .when()
                .post(feedbackUrl);
    }

    @Step("Get feedback with id = '{id}'")
    public Response getFeedbackById(int id) {
        return preparedRequest()
                .log().all()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .get(String.format("%s/%d", feedbackUrl, id));
    }

}