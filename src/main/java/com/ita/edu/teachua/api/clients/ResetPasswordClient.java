package com.ita.edu.teachua.api.clients;

import io.restassured.response.Response;

import java.io.IOException;

public class ResetPasswordClient extends  BaseClient {
    private final String clientUrl;
    public ResetPasswordClient() throws IOException {
        super();
        this.clientUrl = mainValueProvider.getResetPasswordUrl();
    }
    public Response resetPassword(String email){
        return preparedRequest()
                .body(email)
                .when()
                .post(clientUrl);
    }
}
