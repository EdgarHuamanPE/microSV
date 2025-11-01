package com.tecsup.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateOrderRequest {
    private Long userId;
    private Set<CreateOrderItemRequest> items;


}
