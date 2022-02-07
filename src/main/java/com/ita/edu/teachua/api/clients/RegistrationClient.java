package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.registration.RegisterUser;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class RegistrationClient extends BaseClient {
    private final String verifyUrl;
    private final String registrationUrl;

    public RegistrationClient() throws IOException {
        super();
        this.verifyUrl = mainValueProvider.getVerifyUrl();
        this.registrationUrl = mainValueProvider.getRegistrationUrl();
    }

    public Response verifyUser(String code) {
        return preparedRequest()
                .queryParam("code", code)
                .when()
                .get(verifyUrl);
    }

    public Response registerUser(RegisterUser registerUser) {
        return preparedRequest()
                .body(registerUser)
                .when()
                .post(registrationUrl);
    }
}
