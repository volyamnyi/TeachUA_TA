package com.ita.edu.teachua.api.tests;

import io.restassured.RestAssured;

import io.restassured.builder.ResponseSpecBuilder;


public class Specifications {
    public static void setResponseSpecification(int status){
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }
}
