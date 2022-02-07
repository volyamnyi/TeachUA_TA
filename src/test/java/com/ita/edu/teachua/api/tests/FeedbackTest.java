package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.FeedbackClient;
import com.ita.edu.teachua.api.models.feedback.feedback_request.FeedbackRequest;
import com.ita.edu.teachua.api.models.feedback.feedback_response.Feedback;
import com.ita.edu.teachua.api.models.feedback.feedback_response.FeedbackResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class FeedbackTest extends AuthorizedApiTestRunner {

    @Description("[API] Add feedback to the club")
    @Issue("TUA-376")
    @Test(description = "TUA-376")
    public void addFeedbackToClubTest() throws IOException {
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        FeedbackRequest feedback = FeedbackRequest.builder()
                .text("An example of positive feedback")
                .rate(5f)
                .clubId(389)
                .userId(authorization.getCurrentAuthorizedUserID())
                .build();

        Response response = feedbackClient.addNewFeedback(feedback);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertNotNull(response.path("id"));
        softAssert.assertEquals(response.path("rate"), 5.0f);
        softAssert.assertEquals(response.path("text"), "An example of positive feedback");
        softAssert.assertEquals(response.path("clubId"), (Integer) 389);
        softAssert.assertAll();
    }


    @Description("[API] Verify that feedback without text is not added to the club")
    @Issue("TUA-370")
    @Test(description = "TUA-370")
    public void createFeedbackWithEmptyTextFiledTest() throws IOException {
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        FeedbackRequest feedback = FeedbackRequest.builder()
                .rate(4.0f)
                .text("")
                .clubId(5)
                .userId(authorization.getCurrentAuthorizedUserID())
                .build();
        Response response = feedbackClient.addNewFeedback(feedback);

        Assert.assertEquals(response.getStatusCode(), 400);
    }


    @Description("[API] Get feedback by id")
    @Test(description = "TUA")
    public void getFeedbackByIdTest() throws IOException {
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        Response response = feedbackClient.getFeedbackById(10);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.path("id"), (Integer) 10);
        softAssert.assertEquals(response.path("text"), "Verify if error message appears if entered data is invalid\n");
        softAssert.assertAll();
    }

}