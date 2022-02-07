package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.QuestionClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.question.question_request.Question;
import com.ita.edu.teachua.api.models.question.question_response.QuestionResponse;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class QuestionTest extends AuthorizedApiTestRunner {
    @Description("[API] Update title of Frequently Asked Question")
    @Test(description = "TUA")
    public void updateTitleOfFAQTest() throws IOException {
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        QuestionClient questionClient = new QuestionClient(authorization.getToken());
        Question question = Question.builder()
                .title("Як допомогти цьому проекту?")
                .text("Скористайтесь наступним посиланням: https://secure.wayforpay.com/payment/s0f2891d77061")
                .build();
        Response response = questionClient.addNewQuestion(question);
        int questionId = response.path("id");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.path("title"), "Як допомогти цьому проекту?");
        softAssert.assertEquals(response.path("text"), "Скористайтесь наступним посиланням: " +
                "https://secure.wayforpay.com/payment/s0f2891d77061");

        question.setTitle("Як підтримати ваш проект?");
        Response responseUpdate = questionClient.updateQuestionById(question, questionId);

        softAssert.assertEquals(responseUpdate.getStatusCode(), 200);
        softAssert.assertEquals(responseUpdate.path("title"), "Як підтримати ваш проект?");

        Response responseDelete = questionClient.deleteQuestion(questionId);
        softAssert.assertEquals(responseDelete.getStatusCode(), 200);

        softAssert.assertAll();
    }


    @Description("[API] Get FAQ by id")
    @Test(description = "TUA")
    public void getQuestionByIdTest() throws IOException {
        QuestionClient questionClient = new QuestionClient(authorization.getToken());
        Response response = questionClient.getQuestionByID(3);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.path("title "), "Що має містити скарга?");
        softAssert.assertEquals(response.path("text"), "У скарзі обов’язково має бути зазначено: прізвище," +
                " ім’я, по батькові, місце проживання особи, викладено суть скарги, який саме суб’єкт/працівник суб’єкта," +
                " коли, за якою адресою, яким чином порушив право скаржника. Рекомендуємо також додати докази на підтвердження.");
        softAssert.assertAll();
    }

}