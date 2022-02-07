package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.question.question_request.Question;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

public class QuestionClient extends BaseClient {

    protected MainValueProvider valueProvider;
    private final String questionUrl;
    private final String questionsUrl;
    private String token;

    public QuestionClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.questionUrl = mainValueProvider.getQuestionUrl();
        this.questionsUrl = mainValueProvider.getQuestionsUrl();
        this.token = token;
    }

    @Step("Add new question")
    public Response addNewQuestion(Question question) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(question)
                .log().all()
                .when()
                .post(questionUrl);

    }

    @Step("Delete question with id = '{id}'")
    public Response deleteQuestion(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .log().all()
                .when()
                .delete(String.format("%s/%d", questionUrl, id));
    }

    @Step("Get question with id = '{id}'")
    public Response getQuestionByID(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .log().all()
                .when()
                .get(String.format("%s/%d", questionUrl, id));
    }

    @Step("Update question with id = '{id}'")
    public Response updateQuestionById(Question question, int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(question)
                .log().all()
                .when()
                .put(String.format("%s/%d", questionUrl, id));
    }

}