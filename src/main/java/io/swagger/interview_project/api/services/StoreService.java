package io.swagger.interview_project.api.services;

import io.qameta.allure.Step;
import io.swagger.interview_project.api.AssertableResponse;
import io.swagger.interview_project.api.models.storeController.post_orderModel.Order;
import lombok.Getter;

@Getter
public class StoreService extends ApiService {
    private final String STORE_ENDPOINT = "/store";


    @Step("POST Place /order with body {order}")
    public AssertableResponse placeOrder(Order order) {
        var response = baseGiven()
                .body(order)
                .when()
                .post(STORE_ENDPOINT + "/order")
                .then().extract().response();

        return new AssertableResponse(response);

    }
}
