package io.swagger.interview_project.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

@Getter
public class ApiService {

    private String MAIN_URL = "https://petstore.swagger.io/v2";

    protected RequestSpecification baseGiven() {
        return RestAssured.given()
                .baseUri(MAIN_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());
    }
}
