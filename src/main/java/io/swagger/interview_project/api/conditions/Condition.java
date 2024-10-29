package io.swagger.interview_project.api.conditions;

import io.restassured.response.Response;

public interface Condition {

    void check(Response response);

}

