package com.demo.transaction_management.controller;

import com.demo.transaction_management.dto.OrderRequest;
import com.demo.transaction_management.dto.OrderResponse;
import com.demo.transaction_management.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
