package io.swagger.interview_project;

import io.swagger.interview_project.api.models.storeController.post_orderModel.Order;
import io.swagger.interview_project.api.models.storeController.post_orderModel.OrderStatusEnum;
import io.swagger.interview_project.api.services.StoreService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.swagger.interview_project.api.conditions.Conditions.bodyField;
import static io.swagger.interview_project.api.conditions.Conditions.statusCode;
import static io.swagger.interview_project.api.models.storeController.post_orderModel.OrderStatusEnum.PLACED;
import static io.swagger.interview_project.api.utils.TimeGenerator.generateCurrentTime;

public class Post_OrderTest {

    private StoreService storeService = new StoreService();

    //POSITIVE TESTS
    @Test
    @DisplayName("User should be able to place an order")
    public void should_user_place_orderTest() {
        var order = new Order()
                .setPetId(0)
                .setQuantity(0)
                .setId(0)
                .setShipDate(generateCurrentTime())
                .setComplete(true)
                .setStatus(PLACED.getStatus());

        storeService.placeOrder(order)
                .shouldHave(statusCode(200),
                        bodyField("status", Matchers.equalTo(order.getStatus())),
                        bodyField("complete", Matchers.equalTo(order.getComplete())),
                        bodyField("shipDate", Matchers.notNullValue()),
                        bodyField("id", Matchers.notNullValue()),
                        bodyField("quantity", Matchers.equalTo(order.getQuantity())),
                        bodyField("petId", Matchers.equalTo(order.getPetId())));
    }

    @EnumSource(OrderStatusEnum.class)
    @ParameterizedTest
    @DisplayName("User should be able to place an order with status")
    public void should_user_place_order_with_statusTest(OrderStatusEnum orderStatus) {
        var order = new Order()
                .setPetId(0)
                .setQuantity(0)
                .setId(0)
                .setShipDate("2024-10-28T19:13:07.093Z")
                .setStatus(orderStatus.getStatus());

        storeService.placeOrder(order)
                .shouldHave(statusCode(200),
                        bodyField("status", Matchers.equalTo(orderStatus.getStatus())));
    }

    @Test
    @DisplayName("User should be able to place an order without shipDate")
    public void should_user_place_order_without_shipDate() {
        var order = new Order()
                .setPetId(0)
                .setQuantity(0)
                .setId(0)
                .setComplete(true)
                .setStatus(PLACED.getStatus());

        storeService.placeOrder(order)
                .shouldHave(statusCode(200),
                        bodyField("status", Matchers.equalTo(order.getStatus())),
                        bodyField("complete", Matchers.equalTo(order.getComplete())),
                        bodyField("shipDate", Matchers.nullValue()),
                        bodyField("id", Matchers.notNullValue()),
                        bodyField("quantity", Matchers.equalTo(order.getQuantity())),
                        bodyField("petId", Matchers.equalTo(order.getPetId())));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("User should be able to place an order with complete set to true/false")
    public void should_user_place_order_with_complete_true(boolean isComplete) {
        var order = new Order()
                .setComplete(isComplete);

        storeService.placeOrder(order)
                .shouldHave(statusCode(200),
                        bodyField("complete", Matchers.equalTo(order.getComplete())));

    }

}
