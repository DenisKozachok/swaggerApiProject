package io.swagger.interview_project.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.swagger.interview_project.api.conditions.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Getter
public class AssertableResponse {

    private Response response;

    @Step("Api response shouldHave {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }
}