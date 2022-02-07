package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.ResetPasswordClient;
import com.ita.edu.teachua.api.models.reset_password.ResetPassword;
import com.ita.edu.teachua.utils.TestValueProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResetPasswordTest extends ApiTestRunner{
    @Test
    public void resetPasswordTest() throws IOException {
        ResetPasswordClient resetPasswordClient = new ResetPasswordClient();
                Response response=resetPasswordClient
                        .resetPassword(String.format("{\"email\": \"%s\"}",testValueProvider.getAdminEmail()))
                        .then().log().all()
                        .extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
