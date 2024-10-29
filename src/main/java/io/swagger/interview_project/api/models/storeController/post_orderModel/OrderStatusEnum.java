package io.swagger.interview_project.api.models.storeController.post_orderModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String status;
}