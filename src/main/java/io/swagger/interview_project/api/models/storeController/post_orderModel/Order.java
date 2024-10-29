package io.swagger.interview_project.api.models.storeController.post_orderModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order{

	private Integer petId;
	private Integer quantity;
	private Integer id;
	private String shipDate;
	private Boolean complete;
	private String status;
}