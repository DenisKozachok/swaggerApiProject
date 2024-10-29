package io.swagger.interview_project.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import static io.swagger.interview_project.api.configs.ConfigManager.appConfig;

@Getter
public class ApiService {

    protected RequestSpecification baseGiven() {
        return RestAssured.given()
                .baseUri(appConfig().baseUrl())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());
    }
}
