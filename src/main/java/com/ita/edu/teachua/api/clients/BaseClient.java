package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.MainValueProvider;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;



public class BaseClient {
    protected final String baseApiUrl;
    protected final ContentType contentType;
    protected MainValueProvider mainValueProvider;

    public BaseClient() throws IOException {
        mainValueProvider = new MainValueProvider();
        this.baseApiUrl = mainValueProvider.getBaseApiUrl();
        this.contentType = ContentType.JSON;
    }

    @Step("Preparing base request")
    protected RequestSpecification preparedRequest() {
        return given()
                .baseUri(baseApiUrl)
                .contentType(contentType)
                .accept(contentType);
    }

}
