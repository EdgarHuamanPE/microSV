package com.tecsup.order_service.controller;


import com.tecsup.order_service.dto.CreateOrderRequest;
import com.tecsup.order_service.dto.Order;
import com.tecsup.order_service.entity.OrderEntity;
import com.tecsup.order_service.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)

public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        log.info("REST  request  to get  order by  id :{}",id);
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @PostMapping()
    public ResponseEntity<Order> register(
            @RequestBody @Valid CreateOrderRequest createOrderRequest
    )
    {
        //return ResponseEntity.ok().build();

        Order order = orderService.register(createOrderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
