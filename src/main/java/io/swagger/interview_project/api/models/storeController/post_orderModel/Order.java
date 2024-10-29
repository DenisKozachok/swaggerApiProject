package io.swagger.interview_project.api.models.storeController.post_orderModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order{

	@JsonProperty("petId")
	private Integer petId;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private Boolean complete;

	@JsonProperty("status")
	private String status;
}